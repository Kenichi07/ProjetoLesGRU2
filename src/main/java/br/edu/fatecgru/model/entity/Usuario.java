package br.edu.fatecgru.model.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn; 

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String email;
	private String senha;
	private String tipoUsuario;
	
	@ManyToMany
    @JoinTable(
        name = "CURSOS_FAVORITOS",
        joinColumns = @JoinColumn(name = "CUFA_USU_id"),
        inverseJoinColumns = @JoinColumn(name = "CUFA_CUR_id")
    )
	
	private List<Curso> cursosFavoritos;
	
	public Usuario() {
		super();
	}

	public Usuario(int id, String nome, String email, String senha, String tipoUsuario) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.tipoUsuario = tipoUsuario;
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

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

}
