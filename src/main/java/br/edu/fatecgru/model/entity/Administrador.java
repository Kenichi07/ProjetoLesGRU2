package br.edu.fatecgru.model.entity;

import jakarta.persistence.Entity;

@Entity
public class Administrador extends Usuario {

	public Administrador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Administrador(int id, String nome, String email, String senha) {
		super(id, nome, email, senha);
		// TODO Auto-generated constructor stub
	}
  
	
	
}