package models;

import java.util.Date;
import java.util.LinkedList;

public class Viagem {
	
	String descricao;
	String local;
	Date datadeida;
	Date datadevolta;
	EstadoDeParticipacao estado;
	LinkedList<Participante> participantes;
	Usuario dono;
	
	protected void mudarEstado(EstadoDeParticipacao novoestado){
		this.estado = novoestado;
	}
	
	public EstadoDeParticipacao getEstado(){
		return estado;
	}
	
	
	
	public Viagem(String descricao,String local,Date datadeida,Date datadevolta, EstadoDeParticipacao estadoInicial){
		this.participantes = new LinkedList<Participante>();
		this.descricao = descricao;
		this.local = local;
		this.datadeida = datadeida;
		this.datadevolta = datadevolta;
		mudarEstado(estadoInicial); 
	}
}
