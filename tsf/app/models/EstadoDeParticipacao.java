package models;

import exceptions.EstadoException;


public interface EstadoDeParticipacao {
	
	public void adicionarParticipante(Viagem viagem, Usuario participante) throws EstadoException;
	
	public void removerParticipante(Viagem viagem, Usuario participante) throws EstadoException;

	public void tornarFechado(Viagem viagem, String senha) throws EstadoException;

	public void tornarAberto(Viagem viagem) throws EstadoException;

}

