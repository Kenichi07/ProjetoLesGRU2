package br.edu.fatecgru.DTO;

public class ServicoCadastroDTO {
	 private String nome;
	    private String descricao;
	    private Float valor;
	    private int prestadorServicoId;
	    private String nomeCategoria;
	    private String nomeCidade;
	    private String nomeEstado;
	    
		public ServicoCadastroDTO() {}

		public ServicoCadastroDTO(String nome, String descricao, Float valor, int prestadorServicoId, String nomeCategoria, String nomeCidade,
				String nomeEstado) {
			this.nome = nome;
			this.descricao = descricao;
			this.valor = valor;
			this.prestadorServicoId = prestadorServicoId;
			this.nomeCategoria = nomeCategoria;
			this.nomeCidade = nomeCidade;
			this.nomeEstado = nomeEstado;
		}

		public String getNome() {return nome;}
		public void setNome(String nome) {this.nome = nome;}

		public String getDescricao() {return descricao;}
		public void setDescricao(String descricao) {this.descricao = descricao;}

		public Float getValor() {return valor;}
		public void setValor(Float valor) {this.valor = valor;}	
		
		public int getPrestadorServicoId() {return prestadorServicoId;}
		public void setPrestadorServicoId(int prestadorServicoId) {this.prestadorServicoId = prestadorServicoId;}

		public String getNomeCategoria() {return nomeCategoria;}
		public void setNomeCategoria(String nomeCategoria) {this.nomeCategoria = nomeCategoria;}

		public String getNomeCidade() {return nomeCidade;}
		public void setNomeCidade(String nomeCidade) {this.nomeCidade = nomeCidade;}

		public String getNomeEstado() {return nomeEstado;}
		public void setNomeEstado(String nomeEstado) {this.nomeEstado = nomeEstado;}

		
	    
		
	    
}
