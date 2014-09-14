package models;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity(name = "Viagem")
public class Viagem {
	@Id 
	@Column(name="ID")
	long id;
	
	@ManyToOne
	public Usuario dono;
	
	@ManyToMany
	@JoinTable(
	      name="Usuario_Viagem",
	      joinColumns={@JoinColumn(name="Viagem_ID", referencedColumnName="ID")},
	      inverseJoinColumns={@JoinColumn(name="Usuario_ID", referencedColumnName="ID")})
	public List<Usuario> participacoes = new LinkedList<Usuario>();
	
	public String estadoDaViagem;
	public String descricao;
	public String local;
	public Date datadeida;
	public Date datadevolta;
	public String senha = null;

	public Viagem(){
		
	}
	
	public Viagem(String descricao,String local,Date datadeida,Date datadevolta,String estadoInicial, Usuario dono){
		this.estadoDaViagem = estadoInicial;
		this.descricao = descricao;
		this.local = local;
		this.datadeida = datadeida;
		this.datadevolta = datadevolta;
		this.dono = dono;
	}
}
