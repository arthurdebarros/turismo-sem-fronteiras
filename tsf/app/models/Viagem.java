package models;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity(name = "VIAGEM")
public class Viagem {
	@Id 
	@Column(name="ID")
	long id;
	
	//@ManyToOne
	//Usuario dono;
	
	@ManyToMany
	@JoinTable(
	      name="USUARIO_VIAGEM",
	      joinColumns={@JoinColumn(name="VIAGEM_ID", referencedColumnName="ID")},
	      inverseJoinColumns={@JoinColumn(name="USUARIO_ID", referencedColumnName="ID")})
	List<Usuario> participacoes = new LinkedList<Usuario>();
	
	String descricao;
	String local;
	Date datadeida;
	Date datadevolta;
	
	//EstadoDeParticipacao estado;
	
	
	
	
	protected void mudarEstado(EstadoDeParticipacao novoestado){
		//this.estado = novoestado;
	}
	
//	public EstadoDeParticipacao getEstado(){
//		return estado;
//	}
	
	
	public Viagem(String descricao,String local,Date datadeida,Date datadevolta){//, EstadoDeParticipacao estadoInicial){//, Usuario dono){
		//this.estado = estadoInicial;
		this.descricao = descricao;
		this.local = local;
		this.datadeida = datadeida;
		this.datadevolta = datadevolta;
		//this.dono = dono;
	}
}
