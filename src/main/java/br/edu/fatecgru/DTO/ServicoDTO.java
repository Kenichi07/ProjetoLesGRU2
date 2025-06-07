package br.edu.fatecgru.DTO;

import java.util.List;

import br.edu.fatecgru.model.entity.Cidade;
import br.edu.fatecgru.model.entity.Servico;

	public class ServicoDTO {
		//Atributos
		private int id;
	    private String nomeServico;
	    private String descricao;
	    private Float valor;
	    private String nomePrestadorServico;
	    private String numeroWhatsAppPrestadorServico;
	    private String nomeCategoria;
	    private String cidades;
	
	    //Contrutores
	    public ServicoDTO() {}
	
	    public ServicoDTO(Servico s, List<Cidade> cidadesList) {
	        this.id = s.getId();
	        this.nomeServico = s.getNome();
	        this.descricao = s.getDescricao();
	        this.valor = s.getValor();
	        this.nomePrestadorServico = s.getPrestadorservico().getNome();
	        this.numeroWhatsAppPrestadorServico = s.getPrestadorservico().getWhatsApp();
	        this.nomeCategoria = s.getCategoria().getNome();
	        this.cidades = formatarCidades(cidadesList);
	    }
	
	    // Metodos utilitarios
	    private String formatarCidades(List<Cidade> cidades) {
	        StringBuilder sb = new StringBuilder();
	        for (Cidade cidade : cidades) {
	            sb.append(cidade.getNome())
	              .append("/")
	              .append(cidade.getEstado().getSigla())
	              .append(", ");
	        }
	        if (sb.length() > 2) {
	            sb.setLength(sb.length() - 2);
	        }
	        return sb.toString();
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
	
	    public String getNomePrestadorServico() { return nomePrestadorServico; }
	    public void setNomePrestadorServico(String nomePrestadorServico) { this.nomePrestadorServico = nomePrestadorServico; }
	
	    public String getNumeroWhatsAppPrestadorServico() { return numeroWhatsAppPrestadorServico; }
	    public void setNumeroWhatsAppPrestadorServico(String numeroWhatsAppPrestadorServico) { this.numeroWhatsAppPrestadorServico = numeroWhatsAppPrestadorServico; }
	
	    public String getNomeCategoria() { return nomeCategoria; }
	    public void setNomeCategoria(String nomeCategoria) { this.nomeCategoria = nomeCategoria; }
	
	    public String getCidades() { return cidades; }
	    public void setCidades(String cidades) { this.cidades = cidades; }
	   
	}
