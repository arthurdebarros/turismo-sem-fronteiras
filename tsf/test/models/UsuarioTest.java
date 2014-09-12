package models;
import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import models.Usuario;
import models.dao.GenericDAO;
import models.dao.GenericDAOImpl;
import base.AbstractTest;


public class UsuarioTest extends AbstractTest{

	GenericDAO dao = new GenericDAOImpl();
	
	@Test
	public void deveSalvareEncontrar1UsuarioNoBD() {
		Usuario u = new Usuario("admin","admin@gmail.com","1234");
		dao.persist(u);
		assertThat(dao.findAllByClassName("Usuario").size()).isEqualTo(1);
		
	}
	@Test
	public void deveSalvareEncontrarUsuarioNoBD() {
		Usuario u = new Usuario("admin","admin@gmail.com","1234");
		dao.persist(u);
		
		assertThat(dao.findByAttributeName("Usuario", "nome", "admin").size()>0);
	}
}