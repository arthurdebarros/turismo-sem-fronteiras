package models;
import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import exceptions.EstadoException;
import models.Usuario;
import models.Viagem;
import models.dao.GenericDAO;
import models.dao.GenericDAOImpl;
import base.AbstractTest;
import play.mvc.Controller;
import play.mvc.Result;
import play.data.Form;
import play.db.jpa.Transactional;
import controllers.Viagens;
public class ViagemTest extends AbstractTest {

	GenericDAO dao = new GenericDAOImpl();
	
	@Test
	public void testDeveCriarViagemComEstadoDeParticipacao() {
		Usuario Dono = new Usuario("Fulano","fulanodetal@gmail.com","12345");
		String estado = "ABERTO";
		Viagem v = new Viagem("ida a praia", "boa viagem", new Date(), new Date(), estado, Dono);
		assertEquals(Dono,v.getDono());
		assertEquals(estado,v.estado);
	}
	
	@Test
	public void testDeveAdicionarParticipante() {
		Usuario dono = new Usuario("Fulano","fulanodetal@gmail.com","12345");
    	String estado = "ABERTO";
		Viagem v = new Viagem("ida a praia", "boa viagem", new Date(), new Date(), estado, dono);
		Usuario participante = new Usuario ("Sicrano","sicrano@a.b.c","23456");
		Viagens.adicionarParticipante(v, participante);
		assertTrue(v.getParticipacoes().contains(participante));
	}
	
	@Test
	public void testDeveRemoversParticipante() throws EstadoException{
		Usuario dono = new Usuario("Fulano","fulanodetal@gmail.com","12345");
	String estado = "ABERTO";
		Viagem v = new Viagem("ida a praia", "boa viagem", new Date(), new Date(), estado, dono);
		Usuario participante = new Usuario ("Sicrano","sicrano@a.b.c","23456");
		Viagens.adicionarParticipante(v, participante);
		assertTrue(v.getParticipacoes().contains(participante));
		Viagens.removerParticipante(v, participante);
		assertTrue(!v.getParticipacoes().contains(participante));
	}
	
	@Test
	@Transactional
	public void deveSalvareEncontrarViagemNoBD() {
		Usuario dono = new Usuario("Fulano","fulanodetal@gmail.com","12345");
		String estado = "ABERTO";
		Viagem v = new Viagem("ida a praia", "boa viagem", new Date(), new Date(), estado, dono);
		dao.persist(dono);
		dao.persist(v);
		dao.flush();
		assertThat(dao.findByAttributeName("Viagem", "descricao", "ida a praia").size() > 0);
		assertThat(dao.findAllByClassName(Viagem.class.getName()).contains(v));
	}

}
