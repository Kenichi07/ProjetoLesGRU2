package br.edu.fatecgru.model.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Curso {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String descricao;
    private String linkCurso;

    @ManyToOne
    private Categoria categoria;
    
    @ManyToMany(mappedBy = "cursosFavoritos")
    private List<Usuario> usuariosQueFavoritaram;

	public Curso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Curso(int id, String nome, String descricao, String linkCurso, Categoria categoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.linkCurso = linkCurso;
		this.categoria = categoria;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLinkCurso() {
		return linkCurso;
	}

	public void setLinkCurso(String linkCurso) {
		this.linkCurso = linkCurso;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
    
}
