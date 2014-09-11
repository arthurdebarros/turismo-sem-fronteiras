package models;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import controllers.Application;

public class ViagemTest {

	@Test
	public void testDeMudarComportamentoDeParticipacao() {
		Participante p = new Participante("Arthur","arthurdebarros@gmail.com");
		EstadoDeParticipacao comportamento1 = new EstadoParticipacaoSimples();
		Viagem v = new Viagem("ida a praia", "boa viagem", new Date(), new Date(), comportamento1);
		Application controller = new Application();
		controller.criarParticipacao(v, p);
		
		assertTrue(v.participantes.contains(p));
	}

}
