package br.edu.fatecgru.model.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Estado {
	//Atributos
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String sigla;
	   
    //Construtores
    public Estado() {}

	public Estado(String nome, String sigla) {
		this.nome = nome;
		this.sigla = sigla;
	}
	
	//Getters e Setters
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}

	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}

	public String getSigla() {return sigla;}
	public void setSigla(String sigla) {this.sigla = sigla;}

	//Equals e HashCode
	@Override
	public int hashCode() {return Objects.hash(id, nome, sigla);}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)return true;
		if (obj == null)return false;
		if (getClass() != obj.getClass())return false;
		Estado other = (Estado) obj;
		return id == other.id && Objects.equals(nome, other.nome) && Objects.equals(sigla, other.sigla);
	}	
}
