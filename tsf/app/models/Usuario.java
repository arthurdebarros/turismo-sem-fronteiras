package models;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="Usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	

	@ManyToMany(mappedBy = "participacoes")
	private List<Viagem> viagens = new LinkedList<Viagem>();
	
	@OneToMany
	private List<Viagem> viagensCriadas = new LinkedList<Viagem>();
	
	private String email;
	private String pass;
	private String nome;
	
	public Usuario() {
	}
	
	public Usuario(String email, String pass, String nome) {
		this.email = email;
		this.nome = nome;
		this.pass = pass;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Viagem> getViagens() {
		return viagens;
	}

	public void setViagens(List<Viagem> viagens) {
		this.viagens = viagens;
	}

	public List<Viagem> getViagensCriadas() {
		return viagensCriadas;
	}

	public void setViagensCriadas(List<Viagem> viagensCriadas) {
		this.viagensCriadas = viagensCriadas;
	}
}
