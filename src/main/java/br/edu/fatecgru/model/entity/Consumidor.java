package br.edu.fatecgru.model.entity;

import jakarta.persistence.Entity;

@Entity
public class Consumidor extends Usuario{

	private String nome;

	public Consumidor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Consumidor(String nome) {
		super();
		this.nome = nome;
	}
	
	
}
