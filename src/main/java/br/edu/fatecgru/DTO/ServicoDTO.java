package br.edu.fatecgru.DTO;

import java.util.List;

public class ServicoDTO {
	private int id;
    private String nome;
    private String descricao;
    private Float valor;
    private String nomeCategoria;
    private List<CidadeDTO> cidades;
    

    public ServicoDTO(int id, String nome, String descricao, Float valor, String nomeCategoria, List<CidadeDTO> cidades) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.nomeCategoria = nomeCategoria;
       this.cidades = cidades;
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

	public String getNomeCategoria() {return nomeCategoria;}
	public void setNomeCategoria(String nomeCategoria) {this.nomeCategoria = nomeCategoria;}

	public List<CidadeDTO> getCidades() {return cidades;}
	public void setCidades(List<CidadeDTO> cidades) {this.cidades = cidades;}
    
    
}
