package br.edu.fatecgru.model.entity;

import jakarta.persistence.Entity;

@Entity
public class Administrador extends Usuario {

	public Administrador() {
	}

	public Administrador(String nome, String email, String senha) {
		super(nome, email, senha);
	}
  	
}