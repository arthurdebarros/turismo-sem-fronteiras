package controllers;

import static play.data.Form.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import models.Usuario;
import models.Viagem;
import models.dao.GenericDAO;
import models.dao.GenericDAOImpl;
import play.mvc.Controller;
import play.mvc.Result;
import play.data.Form;
import play.db.jpa.Transactional;
import views.html.criacao;

public class Viagens extends Controller {
	private static GenericDAO dao = new GenericDAOImpl();
	private final static Form<Viagem> VIAGEM_FORM = form(Viagem.class);
	

    @Transactional
	private static Usuario getUser(String email) {
		List<Usuario> result = dao.findByAttributeName("Usuario", "email", email);
		return result.size() == 0 ? null : result.get(0);
	}
    @Transactional
    public static Result getCadastroDeViagem(){
    	return ok(criacao.render(getUser(session().get("email"))));
    }
    
    @Transactional
	public static Result CriarViagem()  {
		Form<Viagem> viagemFormRequest = VIAGEM_FORM.bindFromRequest();
		System.out.println(viagemFormRequest.toString());
		if (VIAGEM_FORM.hasErrors()) {
			return badRequest();
		} 
		else {
			Viagem novaViagem = new Viagem();
			try{
				novaViagem.setDatadeida(new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH).parse(form().bindFromRequest().get("datadeida")));
				novaViagem.setDatadevolta(new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH).parse(form().bindFromRequest().get("datadevolta")));
			}catch(ParseException e){
				novaViagem.setDatadeida(new Date());
				novaViagem.setDatadevolta(new Date());
			}	
			novaViagem.setLocal(form().bindFromRequest().get("local"));
			novaViagem.setSenha(null);
			novaViagem.setSenha(form().bindFromRequest().get("senha"));
			novaViagem.setDescricao(form().bindFromRequest().get("descricao"));
			Usuario dono =  getUser(session().get("email"));
			novaViagem.setEstadoDaViagem(form().bindFromRequest().get("estado"));
			novaViagem.setDono(dono);
			novaViagem.getDono().getViagensCriadas().add(novaViagem);
			//dao.merge(novaViagem);
			dao.persist(novaViagem);
			System.out.println("persistiu a VIAGEM: "+ novaViagem.getDescricao());
			flash("fail","Viagem salva com sucesso");
			return redirect(controllers.routes.Application.index());
		}
	}
	
//	public static Result inserirSenhaDaViagem(Viagem v){
//	    return ok(senhaViagem.render(Viagem.descricao))
//	}
	
	public static void adicionarParticipante(Viagem v, Usuario participante){
	    v.getParticipacoes().add(participante);
	}
	
	public static void adicionarParticipante(Viagem v, Usuario participante, String senha){
	    if(v.getSenha() == senha){
	        adicionarParticipante(v,participante);
	    }
	}
	
	public static void removerParticipante(Viagem v, Usuario participante){
	    v.getParticipacoes().remove(participante);
	}
	
	
//	@Transactional
//	public static List<Estado> getStrategiasDeViagens(){
//		return dao.findAllByClassName("Estado");
//	}
}
