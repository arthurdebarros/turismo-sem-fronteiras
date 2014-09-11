package models;

import exceptions.EstadoException;

public class EstadoParticipacaoFechada implements EstadoDeParticipacao{

	private String senha;
	public EstadoParticipacaoFechada(String senha){
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
		viagem.mudarEstado(new EstadoParticipacaoSimples());
		
	}
	
	@Override
	public void removerParticipante(Viagem viagem, Usuario p) throws EstadoException {
		if(!viagem.participantes.remove(p)){
			throw new EstadoException("Participante já existe");
		}
		
	}

}
