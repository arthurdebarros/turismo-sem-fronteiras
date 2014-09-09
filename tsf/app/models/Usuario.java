package models;

import java.util.LinkedList;

public class Usuario extends Participante{

	String senha;
	LinkedList<Viagem> listadeviagens;

	public Usuario(String nome, String email, String senha) {
		super(nome, email);
		this.senha = senha;
	}

}
