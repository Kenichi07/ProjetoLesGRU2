package br.edu.fatecgru.model.entity;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Categoria {

	//Atributos
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    @OneToMany(mappedBy = "categoria")
    private List<Servico> servicos;
	
    //Construtores
    public Categoria() {}
	public Categoria( String nome, List<Servico> servicos) {
		this.nome = nome;
		this.servicos = servicos;
	}

	public Categoria(String nome) {
		super();
		this.nome = nome;
	}
	//Getters e Setters
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}

	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}

	public List<Servico> getServicos() {return servicos;}
	public void setServicos(List<Servico> servicos) {this.servicos = servicos;}
	
	//Equals e HashCode
	@Override
	public int hashCode() {return Objects.hash(id, nome, servicos);}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)return true;
		if (obj == null)return false;
		if (getClass() != obj.getClass())return false;
		Categoria other = (Categoria) obj;
		return id == other.id && Objects.equals(nome, other.nome) && Objects.equals(servicos, other.servicos);
	}	
}
