package br.edu.fatecgru.model.entity;

import jakarta.persistence.Entity;

@Entity
public class ConsumidorServico extends Usuario{

	

	public ConsumidorServico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConsumidorServico(int id, String nome, String email, String senha) {
		super(id, nome, email, senha);
		// TODO Auto-generated constructor stub
	}


}