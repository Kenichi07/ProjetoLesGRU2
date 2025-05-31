package br.edu.fatecgru.model.entity;

import java.util.List;

import jakarta.persistence.Entity;

@Entity
public class Administrador extends Usuario {

	public Administrador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Administrador(int id, String nome, String email, String senha, List<Curso> cursosFavoritos) {
		super(id, nome, email, senha, cursosFavoritos);
		// TODO Auto-generated constructor stub
	}
  
	
	
}