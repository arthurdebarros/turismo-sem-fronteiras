package models;


public interface EstadoDeParticipacao {
	
	public void adicionarParticipante(Viagem viagem, Participante participante) throws EstadoException;

	public void tornarFechado(Viagem viagem, String senha) throws EstadoException;

	public void tornarAberto(Viagem viagem) throws EstadoException;

}
