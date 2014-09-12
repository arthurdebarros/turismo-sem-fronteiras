package models;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import controllers.Application;
import exceptions.EstadoException;

public class ViagemTest {

	@Test
	public void testDeveCriarViagemComEstadoDeParticipacao() {
		Usuario Dono = new Usuario("Fulano","fulanodetal@gmail.com","12345");
		Estado estado = new Estado();
		Viagem v = new Viagem("ida a praia", "boa viagem", new Date(), new Date(), estado, Dono);
		assertEquals(Dono,v.dono);
		assertEquals(estado,v.getEstado());
	}
	
	@Test
	public void testDeveAdicionarParticipante() throws EstadoException{
		Usuario dono = new Usuario("Fulano","fulanodetal@gmail.com","12345");
		Estado estado = new Estado();
		Viagem v = new Viagem("ida a praia", "boa viagem", new Date(), new Date(), estado, dono);
		Usuario participante = new Usuario ("Sicrano","sicrano@a.b.c","23456");
		v.getEstado().adicionarParticipante(v, participante);
		assertTrue(v.participacoes.contains(participante));
	}
	
	@Test
	public void testDeveRemoversParticipante() throws EstadoException{
		Usuario dono = new Usuario("Fulano","fulanodetal@gmail.com","12345");
		Estado estado = new Estado();
		Viagem v = new Viagem("ida a praia", "boa viagem", new Date(), new Date(), estado, dono);
		Usuario participante = new Usuario ("Sicrano","sicrano@a.b.c","23456");
		v.getEstado().adicionarParticipante(v, participante);
		assertTrue(v.participacoes.contains(participante));
		v.getEstado().removerParticipante(v, participante);
		assertTrue(!v.participacoes.contains(participante));
	}

}
