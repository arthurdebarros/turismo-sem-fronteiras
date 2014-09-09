package models;


public class EstadoParticipacaoAberta implements EstadoDeParticipacao {

	@Override
	public void adicionarParticipante(Viagem viagem, Participante p) {
		viagem.participantes.add(p);
	}

	@Override
	public void tornarFechado(Viagem viagem, String senha) {
		viagem.mudarEstado(new EstadoParticipacaoFechada(senha));
	}

	@Override
	public void tornarAberto(Viagem viagem) throws EstadoException {
		throw new EstadoException("A viagem já é aberta");
		
	}
}