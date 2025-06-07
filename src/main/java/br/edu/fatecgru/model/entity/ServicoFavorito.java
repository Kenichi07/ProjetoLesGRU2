package br.edu.fatecgru.model.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class ServicoFavorito {
	
	//Atributos
	@EmbeddedId
    private ServicoFavoritoPK id;

	// Construtores
    public ServicoFavorito() {}
    public ServicoFavorito(ServicoFavoritoPK pk) {id = pk;}
    public ServicoFavorito(Usuario usuario, Servico servico) {
        this.id = new ServicoFavoritoPK(usuario, servico);
    }

    // Getters e Setters
    public ServicoFavoritoPK getId() { return id; }
    public void setId(ServicoFavoritoPK id) { this.id = id; }
}
