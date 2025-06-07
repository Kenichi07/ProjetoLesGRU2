package br.edu.fatecgru.model.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class CursoFavorito {
	//Atributos
	@EmbeddedId
    private CursoFavoritoPK id;

	//Construtores
    public CursoFavorito() {}
    public CursoFavorito(CursoFavoritoPK pk) {id = pk;}
    public CursoFavorito(Usuario usuario, Curso curso) {
        this.id = new CursoFavoritoPK(usuario, curso);
    }
    
 // Getters e Setters
	public CursoFavoritoPK getId() {return id;}
	public void setId(CursoFavoritoPK id) {this.id = id;}  
}
