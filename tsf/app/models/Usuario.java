package models;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import javax.persistence.OneToMany;

@Entity(name="USUARIO")
public class Usuario {

	@Id
	@Column(name = "ID")
	private long id;
	
	private String email;
	private String pass;
	private String nome;
	
	@ManyToMany(mappedBy="participacoes")
	List<Viagem> viagens= new LinkedList<Viagem>();
	
	//@OneToMany(mappedBy = "dono")
	//List<Viagem> viagenscriadas;
	public Usuario() {
	}
	
	public Usuario(String email, String pass, String nome) {
		this.email = email;
		this.nome = nome;
		this.pass = pass;
	//	this.viagenscriadas = new LinkedList<Viagem>();
	//	this.viagens = new LinkedList<Viagem>();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
