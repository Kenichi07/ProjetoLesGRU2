package br.edu.fatecgru.model.entity;

import jakarta.persistence.Entity;

@Entity
public class ConsumidorServico extends Usuario{
	public ConsumidorServico() {}
	public ConsumidorServico(String nome, String email, String senha) {super(nome, email, senha);}
}