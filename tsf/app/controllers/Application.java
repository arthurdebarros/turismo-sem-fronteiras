package controllers;

import models.dao.GenericDAO;
import models.dao.GenericDAOImpl;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {

	private static GenericDAO dao = new GenericDAOImpl();
	
    public static Result index() {
		if (session().get("user") == null) {
			return redirect(routes.Login.show());
		}
        return ok(index.render("Home Page"));
    }
    
	@Transactional
	private static void salvarNoBanco(Object object) {
		dao.persist(object);
		dao.flush();
	}
    public static Result CriarViagem() {
    	return ok();
    }

}
