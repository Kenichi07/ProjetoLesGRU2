package br.edu.fatecgru.model.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany; 

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String email;
	private String senha;
	
	@ManyToMany
    @JoinTable(
        name = "CURSOS_FAVORITOS",
        joinColumns = @JoinColumn(name = "CUFA_USU_id"),
        inverseJoinColumns = @JoinColumn(name = "CUFA_CUR_id")
    )
	@JsonManagedReference
	private List<Curso> cursosFavoritos;
	
	@ManyToMany
    @JoinTable(
        name = "SERVICOS_FAVORITOS",
        joinColumns = @JoinColumn(name = "SEFA_CON_USU_id"),
        inverseJoinColumns = @JoinColumn(name = "SEFA_SER_id")
    )
    private List<Servico> servicosFavoritos;
	
	public Usuario() {
		super();
	}

	public Usuario(int id, String nome, String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Curso> getCursosFavoritos() {
		return cursosFavoritos;
	}

	public void setCursosFavoritos(List<Curso> cursosFavoritos) {
		this.cursosFavoritos = cursosFavoritos;
	}

	public List<Servico> getServicosFavoritos() {
		return servicosFavoritos;
	}

	public void setServicosFavoritos(List<Servico> servicosFavoritos) {
		this.servicosFavoritos = servicosFavoritos;
	}
	
}
