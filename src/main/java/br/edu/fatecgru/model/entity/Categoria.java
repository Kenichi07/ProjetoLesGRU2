package br.edu.fatecgru.model.entity;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Categoria {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    
    @OneToMany(mappedBy = "categoria")
    private List<Servico> servicos;
	
    public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categoria(int id, String nome, List<Servico> servicos) {
		super();
		this.id = id;
		this.nome = nome;
		this.servicos = servicos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}
	
}
