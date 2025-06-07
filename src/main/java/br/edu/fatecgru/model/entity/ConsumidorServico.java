package br.edu.fatecgru.model.entity;

import jakarta.persistence.Entity;

@Entity
public class ConsumidorServico extends Usuario{
	
	//Construtores
	public ConsumidorServico() {}
	public ConsumidorServico(String nome, String email, String senha) {super(nome, email, senha);}
}