package br.edu.fatecgru.model.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
    @JsonBackReference
    private List<Usuario> usuariosQueFavoritaram;

	public Curso() {
		// TODO Auto-generated constructor stub
	}

	public Curso(int id, String nome, String descricao, String linkCurso, Categoria categoria) {
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

	public List<Usuario> getUsuariosQueFavoritaram() {
		return usuariosQueFavoritaram;
	}

	public void setUsuariosQueFavoritaram(List<Usuario> usuariosQueFavoritaram) {
		this.usuariosQueFavoritaram = usuariosQueFavoritaram;
	}
    
}
