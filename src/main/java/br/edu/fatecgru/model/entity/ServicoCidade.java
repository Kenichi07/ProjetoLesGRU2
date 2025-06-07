package br.edu.fatecgru.model.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class ServicoCidade {
	//Atributos
	@EmbeddedId
    private ServicoCidadePK id;

	//Construtores
    public ServicoCidade() {}
    public ServicoCidade(Servico servico, Cidade cidade) {
        this.id = new ServicoCidadePK(servico, cidade);
    }

    // Getters e Setters
    public ServicoCidadePK getId() {return id;}
    public void setId(ServicoCidadePK id) {this.id = id;}
	
}
