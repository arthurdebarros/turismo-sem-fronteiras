package models;

import java.util.Date;
import java.util.LinkedList;

public class Viagem {
	
	String descricao;
	String local;
	Date datadeida;
	Date datadevolta;
	EstadoDeParticipacao estado;
	Usuario dono;
	LinkedList<Usuario> participantes;
	
	protected void mudarEstado(EstadoDeParticipacao novoestado){
		this.estado = novoestado;
	}
	
	public EstadoDeParticipacao getEstado(){
		return estado;
	}
	
	
	public Viagem(String descricao,String local,Date datadeida,Date datadevolta, EstadoDeParticipacao estadoInicial, Usuario dono){
		this.participantes = new LinkedList<Usuario>();
		this.descricao = descricao;
		this.local = local;
		this.datadeida = datadeida;
		this.datadevolta = datadevolta;
		this.dono = dono;
		mudarEstado(estadoInicial); 
	}
}
