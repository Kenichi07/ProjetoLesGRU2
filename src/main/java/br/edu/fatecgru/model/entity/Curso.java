package br.edu.fatecgru.model.entity;

import java.util.Objects;

import br.edu.fatecgru.DTO.CursoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Curso {

	//Atributos
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    private String linkCurso;
    @ManyToOne
    private Categoria categoria;

    // Construtores
    public Curso() {}
    public Curso(String nome, String descricao, String linkCurso, Categoria categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.linkCurso = linkCurso;
        this.categoria = categoria;
    }

    // Método utilitário
    public CursoDTO toDTO() {
        return new CursoDTO(this);
    }

    // Getters e Setters
    public Integer getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getLinkCurso() { return linkCurso; }
    public void setLinkCurso(String linkCurso) { this.linkCurso = linkCurso; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
    
    //Equals e HashCode
	@Override
	public int hashCode() {return Objects.hash(categoria, descricao, id, linkCurso, nome);}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)return true;
		if (obj == null)return false;
		if (getClass() != obj.getClass())return false;
		Curso other = (Curso) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(descricao, other.descricao)
				&& id == other.id && Objects.equals(linkCurso, other.linkCurso) && Objects.equals(nome, other.nome);
	}   
}
