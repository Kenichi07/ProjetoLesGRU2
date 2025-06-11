package br.edu.fatecgru.DTO;

import br.edu.fatecgru.model.entity.Servico;

public class ServicoCadastroDTO {
	private Integer id; 
	private String nome;
	private String descricao;
	private Float valor;
	private int prestadorId;
	private String nomeCategoria;
	private String nomeCidade;
	private String nomeEstado;

	public ServicoCadastroDTO() {}

	public ServicoCadastroDTO(Integer id, String nome, String descricao, Float valor, int prestadorServicoId, String nomeCategoria, String nomeCidade,
			String nomeEstado) {
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.prestadorId = prestadorServicoId;
		this.nomeCategoria = nomeCategoria;
		this.nomeCidade = nomeCidade;
		this.nomeEstado = nomeEstado;
	}
	
	public ServicoCadastroDTO(Servico s) {
        this.id = s.getId();
        this.nome = s.getNome();
        this.descricao = s.getDescricao();
        this.valor = s.getValor();
        this.nomeCategoria = s.getCategoria().getNome();
        this.nomeCidade = s.getCidade().getNome();
        this.nomeEstado = s.getCidade().getEstado().getNome();
    }
	
	public ServicoCadastroDTO(Integer id, String nome, String descricao, Float valor, String nomeCategoria, String nomeCidade,
			String nomeEstado) {
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.nomeCategoria = nomeCategoria;
		this.nomeCidade = nomeCidade;
		this.nomeEstado = nomeEstado;
	}
	
	public ServicoDTO toServicoDTO() {
		return new ServicoDTO(id, nome, descricao, valor, nomeCategoria, nomeCidade);	
	}
	
	public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}

	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}

	public String getDescricao() {return descricao;}
	public void setDescricao(String descricao) {this.descricao = descricao;}

	public Float getValor() {return valor;}
	public void setValor(Float valor) {this.valor = valor;}	

	public int getPrestadorServicoId() {return prestadorId;}
	public void setPrestadorServicoId(int prestadorServicoId) {this.prestadorId = prestadorServicoId;}

	public String getNomeCategoria() {return nomeCategoria;}
	public void setNomeCategoria(String nomeCategoria) {this.nomeCategoria = nomeCategoria;}

	public String getNomeCidade() {return nomeCidade;}
	public void setNomeCidade(String nomeCidade) {this.nomeCidade = nomeCidade;}

	public String getNomeEstado() {return nomeEstado;}
	public void setNomeEstado(String nomeEstado) {this.nomeEstado = nomeEstado;}	    
}
