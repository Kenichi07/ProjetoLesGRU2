package br.edu.fatecgru.DTO;

public class ServicoUpdateDTO {
	private Integer id;
	private String nome;
    private String descricao;
    private Float valor;
    private String nomeCategoria;
    private String nomeCidade;

    // Construtores
    public ServicoUpdateDTO() {}

    public ServicoUpdateDTO(String nome, String descricao, Float valor, String nomeCategoria, String nomeCidade) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.nomeCategoria = nomeCategoria;
        this.nomeCidade = nomeCidade;
    }

    // Getters e Setters
    public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}
    
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Float getValor() { return valor; }
    public void setValor(Float valor) { this.valor = valor; }

    public String getNomeCategoria() { return nomeCategoria; }
    public void setNomeCategoria(String nomeCategoria) { this.nomeCategoria = nomeCategoria; }

    public String getNomeCidade() { return nomeCidade; }
    public void setNomeCidade(String nomeCidade) { this.nomeCidade = nomeCidade; }
}
