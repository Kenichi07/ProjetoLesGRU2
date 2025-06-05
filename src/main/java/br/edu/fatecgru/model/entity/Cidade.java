package br.edu.fatecgru.model.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Cidade {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	
	@ManyToOne
	private Estado estado;
	
	@ManyToMany(mappedBy = "servicoCidade")
	private List<Servico> servicoCidade;
	
	public Cidade() {	
	}

	public Cidade(String nome, Estado estado, List<Servico> servicoCidade) {
		this.nome = nome;
		this.estado = estado;
		this.servicoCidade = servicoCidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Servico> getServicoCidade() {
		return servicoCidade;
	}

	public void setServicoCidade(List<Servico> servicoCidade) {
		this.servicoCidade = servicoCidade;
	}

}
