package models;

public class EstadoParticipacaoFechada implements EstadoDeParticipacao{

	private String senha;
	public EstadoParticipacaoFechada(String senha){
		this.senha = senha;
	}
	
	@Override
	public void adicionarParticipante(Viagem viagem, Participante participante) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tornarFechado(Viagem viagem, String senha) throws EstadoException {
		throw new EstadoException("A viagem já é fechada");
		
	}

	@Override
	public void tornarAberto(Viagem viagem) {
		viagem.mudarEstado(new EstadoParticipacaoAberta());
		
	}

}
