package br.edu.fatecgru.model.entity;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Servico {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String descricao;
    private Float valor;
	
    @ManyToOne
    private PrestadorServico prestadorservico;
    
    @ManyToOne
    private Categoria categoria;
    
    @ManyToMany(mappedBy = "servicosFavoritos")
    private List<ConsumidorServico> consumidoresQueFavoritaram;
       
    @ManyToMany
    @JoinTable(
        name = "SERVICOS_CIDADES",
        joinColumns = @JoinColumn(name = "SECI_SER_Id"),
        inverseJoinColumns = @JoinColumn(name = "SECI_CID_Id")
    )
	
	private List<Cidade> servicoCidade;
    
    @ManyToOne
    private Estado estado;
    
    public Servico() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	public Servico(int id, String nome, String descricao, Float valor, PrestadorServico prestadorservico,
			Categoria categoria, List<ConsumidorServico> consumidoresQueFavoritaram, List<Cidade> servicoCidade,
			Estado estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.prestadorservico = prestadorservico;
		this.categoria = categoria;
		this.consumidoresQueFavoritaram = consumidoresQueFavoritaram;
		this.servicoCidade = servicoCidade;
		this.estado = estado;
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

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public PrestadorServico getPrestadorservico() {
		return prestadorservico;
	}

	public void setPrestadorservico(PrestadorServico prestadorservico) {
		this.prestadorservico = prestadorservico;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<ConsumidorServico> getConsumidoresQueFavoritaram() {
		return consumidoresQueFavoritaram;
	}

	public void setConsumidoresQueFavoritaram(List<ConsumidorServico> consumidoresQueFavoritaram) {
		this.consumidoresQueFavoritaram = consumidoresQueFavoritaram;
	}

	public List<Cidade> getServicoCidade() {
		return servicoCidade;
	}

	public void setServicoCidade(List<Cidade> servicoCidade) {
		this.servicoCidade = servicoCidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
}
