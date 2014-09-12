package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;

import exceptions.EstadoException;

@Entity
@Inheritance
public class Estado {
	@Id
	@GeneratedValue
	long id;
	
	public void adicionarParticipante(Viagem viagem, Usuario p) {
		viagem.participacoes.add(p);
	}

	public void tornarFechado(Viagem viagem, String senha) throws EstadoException {
		viagem.mudarEstado(new EstadoFechado(senha));
	}


	public void tornarAberto(Viagem viagem) throws EstadoException {
		throw new EstadoException("A viagem já é aberta");
		
	}


	public void removerParticipante(Viagem viagem, Usuario p) throws EstadoException {
		if(!viagem.participacoes.remove(p)){
			throw new EstadoException("Participante já existe");
		}
		
	}
}
