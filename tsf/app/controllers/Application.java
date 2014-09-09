package controllers;

import models.Participante;
import models.Viagem;
import play.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
	public Result criarParticipacao(Viagem v, Participante p){
		try{
			v.getEstado().adicionarParticipante(v, p);
			return ok(index.render("Participante adicionado"));
		}catch (Exception e){
			return badRequest();
		}
	}

	public Result setSenha(Viagem v, String senha){
		try{
			v.getEstado().tornarFechado(v, senha);
			return ok(index.render("Agora sua viagem é protegida por senha"));
		}catch (Exception e){
			return badRequest();
		}
	}

	public Result tornarAberto(Viagem v){
		try{
			v.getEstado().tornarAberto(v);
			return ok(index.render("Agora qualquer um pode entrar em sua viagem"));
		}catch (Exception e){
			return badRequest();
		}
	}


}
