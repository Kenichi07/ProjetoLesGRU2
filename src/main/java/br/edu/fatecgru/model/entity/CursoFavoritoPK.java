package br.edu.fatecgru.model.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class CursoFavoritoPK implements Serializable{
	
	//Atributos
	@ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    //Construtores
    public CursoFavoritoPK() {}
    public CursoFavoritoPK(Usuario usuario, Curso curso) {
        this.usuario = usuario;
        this.curso = curso;
    }
  
    //Getters e Setters    
	public Usuario getUsuario() {return usuario;}
	public void setUsuario(Usuario usuario) {this.usuario = usuario;}
	
	public Curso getCurso() {return curso;}
	public void setCurso(Curso curso) {this.curso = curso;}
	
	// Equals e HashCode (importante!)
	@Override
	public int hashCode() {return Objects.hash(curso, usuario);}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)return true;
		if (obj == null)return false;
		if (getClass() != obj.getClass())return false;
		CursoFavoritoPK other = (CursoFavoritoPK) obj;
		return Objects.equals(curso, other.curso) && Objects.equals(usuario, other.usuario);
	}   
}
