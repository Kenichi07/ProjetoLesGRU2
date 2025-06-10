package br.edu.fatecgru.model.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Servico {
	
	//Atributos
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String descricao;
    private Float valor;   
    @ManyToOne
    private Cidade cidade;
    @ManyToOne
    private PrestadorServico prestadorservico;
    @ManyToOne
    private Categoria categoria;
   
    // Construtores
    public Servico() {}
    public Servico(String nome, String descricao, Float valor,Cidade cidade, PrestadorServico prestadorservico,
                   Categoria categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.cidade = cidade;
        this.prestadorservico = prestadorservico;
        this.categoria = categoria;
    }

    public Servico(Servico s) {
        this.nome = s.getNome();
        this.descricao = s.getDescricao();
        this.valor = s.getValor();
        this.cidade = s.getCidade();
        this.prestadorservico = s.getPrestadorservico();
        this.categoria = s.getCategoria();
        }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Float getValor() { return valor; }
    public void setValor(Float valor) { this.valor = valor; }
    
    public Cidade getCidade() {return cidade;}
	public void setCidade(Cidade cidade) {this.cidade = cidade;}
	
	public PrestadorServico getPrestadorservico() { return prestadorservico; }
    public void setPrestadorservico(PrestadorServico prestadorservico) { this.prestadorservico = prestadorservico; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

	//Equals e HashCode
	@Override
	public int hashCode() {return Objects.hash(categoria, descricao, id, nome, prestadorservico, valor);}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)return true;
		if (obj == null)return false;
		if (getClass() != obj.getClass())return false;
		Servico other = (Servico) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(descricao, other.descricao)
				&& id == other.id && Objects.equals(nome, other.nome)&& Objects.equals(prestadorservico, other.prestadorservico) 
				&& Objects.equals(valor, other.valor);
	}
}
