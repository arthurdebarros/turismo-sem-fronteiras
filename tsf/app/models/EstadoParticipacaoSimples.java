package models;

import exceptions.EstadoException;


public class EstadoParticipacaoSimples implements EstadoDeParticipacao {

	@Override
	public void adicionarParticipante(Viagem viagem, Usuario p) {
		viagem.participantes.add(p);
	}

	@Override
	public void tornarFechado(Viagem viagem, String senha) throws EstadoException {
		viagem.mudarEstado(new EstadoParticipacaoFechada(senha));
	}

	@Override
	public void tornarAberto(Viagem viagem) throws EstadoException {
		throw new EstadoException("A viagem já é aberta");
		
	}

	@Override
	public void removerParticipante(Viagem viagem, Usuario p) throws EstadoException {
		if(!viagem.participantes.remove(p)){
			throw new EstadoException("Participante já existe");
		}
		
	}
}