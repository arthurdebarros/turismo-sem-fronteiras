package controllers;

import static play.data.Form.form;

import java.util.List;

import models.Estado;
import models.Usuario;
import models.Viagem;
import models.dao.GenericDAO;
import models.dao.GenericDAOImpl;
import play.mvc.Controller;
import play.mvc.Result;
import play.data.Form;
import play.db.jpa.Transactional;
import views.html.login;

public class Viagens extends Controller {
	private static GenericDAO dao = new GenericDAOImpl();
	private final static Form<Viagem> VIAGEM_FORM = form(Viagem.class);
	

    @Transactional
	private static Usuario getUser(String email) {
		List<Usuario> result = dao.findByAttributeName("Usuario", "email", email);
		return result.size() == 0 ? null : result.get(0);
	}
    
    @Transactional
	public static Result CriarViagem()  {
		Form<Viagem> viagemFormRequest = VIAGEM_FORM.bindFromRequest();
		if (VIAGEM_FORM.hasErrors()) {
			return badRequest();
		} 
		else {
			Viagem novaViagem = viagemFormRequest.get();
			
			Long idEstado = Long.parseLong(form().bindFromRequest().get("estado"));
			Estado estadoinicial = dao.findByEntityId(Estado.class, idEstado);
			novaViagem.dono = getUser(session().get("user"));
			novaViagem.mudarEstado(estadoinicial);
			dao.persist(novaViagem);
			dao.flush();
			return redirect(controllers.routes.Application.index());
		}
	}
	
	@Transactional
	public static List<Estado> getStrategiasDeViagens(){
		return dao.findAllByClassName("Estado");
	}
}
