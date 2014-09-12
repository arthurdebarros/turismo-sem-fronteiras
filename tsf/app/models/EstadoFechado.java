package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import exceptions.EstadoException;
//@Entity
public class EstadoFechado extends Estado{
	//@Id
	//@GeneratedValue
	//long id;
	
	private String senha;
	public EstadoFechado(String senha){
		this.senha = senha;
	}
	
	@Override
	public void adicionarParticipante(Viagem viagem, Usuario participante) {
		
		
	}

	@Override
	public void tornarFechado(Viagem viagem, String senha) throws EstadoException {
		throw new EstadoException("A viagem já é fechada");
		
	}

	@Override
	public void tornarAberto(Viagem viagem) {
		viagem.mudarEstado(new Estado());
		
	}
	
	@Override
	public void removerParticipante(Viagem viagem, Usuario p) throws EstadoException {
		if(!viagem.participacoes.remove(p)){
			throw new EstadoException("Participante já existe");
		}
		
	}

}
