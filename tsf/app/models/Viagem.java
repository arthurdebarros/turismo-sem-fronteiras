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
	@GeneratedValue
	@Id 
	@Column(name="ID")
	private
	long id;
	
	@ManyToOne
	private Usuario dono;
	
	@ManyToMany
	@JoinTable(
	      name="Usuario_Viagem",
	      joinColumns={@JoinColumn(name="Viagem_ID", referencedColumnName="ID")},
	      inverseJoinColumns={@JoinColumn(name="Usuario_ID", referencedColumnName="ID")})
	private List<Usuario> participacoes = new LinkedList<Usuario>();
	private String titulo;
	private String estadoDaViagem;
	private String descricao;
	private String local;
	private Date datadeida;
	private Date datadevolta;
	private String senha = null;

	public Viagem(){
		
	}
	
	public Viagem(String descricao,String local,Date datadeida,Date datadevolta,String estadoInicial, Usuario dono){
		this.setEstadoDaViagem(estadoInicial);
		this.setDescricao(descricao);
		this.setLocal(local);
		this.setDatadeida(datadeida);
		this.setDatadevolta(datadevolta);
		this.setDono(dono);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Usuario getDono() {
		return dono;
	}

	public void setDono(Usuario dono) {
		this.dono = dono;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEstadoDaViagem() {
		return estadoDaViagem;
	}

	public void setEstadoDaViagem(String estadoDaViagem) {
		this.estadoDaViagem = estadoDaViagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Date getDatadeida() {
		return datadeida;
	}

	public void setDatadeida(Date datadeida) {
		this.datadeida = datadeida;
	}

	public Date getDatadevolta() {
		return datadevolta;
	}

	public void setDatadevolta(Date datadevolta) {
		this.datadevolta = datadevolta;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Usuario> getParticipacoes() {
		return participacoes;
	}

	public void setParticipacoes(List<Usuario> participacoes) {
		this.participacoes = participacoes;
	}
}
