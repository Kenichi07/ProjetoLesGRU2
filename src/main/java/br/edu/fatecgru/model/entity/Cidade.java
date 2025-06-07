package br.edu.fatecgru.model.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Cidade {

	//Atributos
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    @ManyToOne
    private Estado estado;

    // Construtores
    public Cidade() {}
    public Cidade(String nome, Estado estado) {
        this.nome = nome;
        this.estado = estado;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Estado getEstado() { return estado; }
    public void setEstado(Estado estado) { this.estado = estado; }
    
    //Equals e HashCode
	@Override
	public int hashCode() {return Objects.hash(estado, id, nome);}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)return true;
		if (obj == null)return false;
		if (getClass() != obj.getClass())return false;
		Cidade other = (Cidade) obj;
		return Objects.equals(estado, other.estado) && id == other.id && Objects.equals(nome, other.nome);
	}	
}
