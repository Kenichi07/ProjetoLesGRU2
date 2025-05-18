package br.edu.fatecgru.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String email;
	private String senha;
	private String tipoUsuario;
	private String whatsapp;
	
	//CONTRUTORES
	public Usuario() {
		
	}

	public Usuario(int id, String nome, String email, String senha, String tipoUsuario, String whatsapp) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.tipoUsuario = tipoUsuario;
		this.whatsapp = whatsapp;
	}
	
	
	
}
