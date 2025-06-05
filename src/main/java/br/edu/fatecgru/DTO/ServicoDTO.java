package br.edu.fatecgru.DTO;

import java.util.List;

import br.edu.fatecgru.model.entity.Servico;

public class ServicoDTO {
	private int id;
    private String nomeServico;
    private String descricao;
    private Float valor;
    private String nomePrestadorServico;
    private String numeroWhatsAppPrestadorServico;
    private String nomeCategoria;
    private List<CidadeDTO> cidades;
    
    public ServicoDTO() {}
    
    public ServicoDTO(Servico s) {
    	id = s.getId();
    	nomeServico = s.getNome();
    	valor = s.getValor();
    	nomePrestadorServico = s.getPrestadorservico().getNome();
    	numeroWhatsAppPrestadorServico = s.getPrestadorservico().getWhatsApp();
    	nomeCategoria = s.getCategoria().getNome();
    	cidades = s.getServicoCidade().stream().map(c -> new CidadeDTO(c)).toList();
    }
    
	public ServicoDTO(int id, String nomeServico, String descricao, Float valor, String nomePrestadorServico,
			String numeroTelefPrestadorServico, String nomeCategoria, List<CidadeDTO> cidades) {
		this.id = id;
		this.nomeServico = nomeServico;
		this.descricao = descricao;
		this.valor = valor;
		this.nomePrestadorServico = nomePrestadorServico;
		this.numeroWhatsAppPrestadorServico = numeroTelefPrestadorServico;
		this.nomeCategoria = nomeCategoria;
		this.cidades = cidades;
	}
	// Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNomeServico() { return nomeServico; }
    public void setNomeServico(String nomeServico) { this.nomeServico = nomeServico; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Float getValor() { return valor; }
    public void setValor(Float valor) { this.valor = valor; }
    
    public String getNomePrestadorServico() {return nomePrestadorServico;}
	public void setNomePrestadorServico(String nomePrestadorServico) {this.nomePrestadorServico = nomePrestadorServico;}

	public String getNumeroWhatsAppPrestadorServico() {return numeroWhatsAppPrestadorServico;}
	public void setNumeroWhatsAppPrestadorServico(String numeroWhatsAppPrestadorServico) {this.numeroWhatsAppPrestadorServico = numeroWhatsAppPrestadorServico;}

	public String getNomeCategoria() {return nomeCategoria;}
	public void setNomeCategoria(String nomeCategoria) {this.nomeCategoria = nomeCategoria;}

	public List<CidadeDTO> getCidades() {return cidades;}
	public void setCidades(List<CidadeDTO> cidades) {this.cidades = cidades;}
    
    
}
