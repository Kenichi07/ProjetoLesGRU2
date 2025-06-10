package br.edu.fatecgru.DTO;

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
	    private String cidade;
	    private String estado;
	    
	    //Contrutores
	    public ServicoDTO() {}
	
	    public ServicoDTO(Servico s) {
	        this.id = s.getId();
	        this.nomeServico = s.getNome();
	        this.descricao = s.getDescricao();
	        this.valor = s.getValor();
	        this.nomePrestadorServico = s.getPrestadorservico().getNome();
	        this.numeroWhatsAppPrestadorServico = s.getPrestadorservico().getWhatsApp();
	        this.nomeCategoria = s.getCategoria().getNome();
	        this.cidade = s.getCidade().getNome();
	        this.estado = s.getCidade().getEstado().getNome();
	    }

	 // Getters e Setters
		public int getId() {return id;}
		public void setId(int id) {this.id = id;}

		public String getNomeServico() {return nomeServico;}
		public void setNomeServico(String nomeServico) {this.nomeServico = nomeServico;}

		public String getDescricao() {return descricao;}
		public void setDescricao(String descricao) {this.descricao = descricao;}

		public Float getValor() {return valor;}
		public void setValor(Float valor) {this.valor = valor;}

		public String getNomePrestadorServico() {return nomePrestadorServico;}
		public void setNomePrestadorServico(String nomePrestadorServico) {this.nomePrestadorServico = nomePrestadorServico;}

		public String getNumeroWhatsAppPrestadorServico() {return numeroWhatsAppPrestadorServico;}
		public void setNumeroWhatsAppPrestadorServico(String numeroWhatsAppPrestadorServico) {this.numeroWhatsAppPrestadorServico = numeroWhatsAppPrestadorServico;}

		public String getNomeCategoria() {return nomeCategoria;}
		public void setNomeCategoria(String nomeCategoria) {this.nomeCategoria = nomeCategoria;}

		public String getCidade() {return cidade;}
		public void setCidade(String cidade) {this.cidade = cidade;}

		public String getEstado() {return estado;}
		public void setEstado(String estado) {this.estado = estado;}
	}
