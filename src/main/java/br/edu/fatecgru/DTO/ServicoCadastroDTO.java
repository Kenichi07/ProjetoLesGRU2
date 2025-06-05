package br.edu.fatecgru.DTO;

import java.util.List;

public class ServicoCadastroDTO {
	 private String nome;
	    private String descricao;
	    private Float valor;
	    // private int prestadorServicoId; 
	    //(OBS: VAI DEPENDER DE COMO SERA FEITA A AUTENTICAÇÃO, PASSANDO ID DO FRONT PARA O BACK OU UTILIZANDO SPRING SECURITY PARA AUTENTICAR)
	    private int idCategoria;
	    private List<Integer> idsCidades;
	    private int idEstado;
	    
		public ServicoCadastroDTO(String nome, String descricao, Float valor, int idCategoria, List<Integer> idsCidades,
				int idEstado) {
			this.nome = nome;
			this.descricao = descricao;
			this.valor = valor;
			this.idCategoria = idCategoria;
			this.idsCidades = idsCidades;
			this.idEstado = idEstado;
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

		public int getIdCategoria() {
			return idCategoria;
		}

		public void setIdCategoria(int idCategoria) {
			this.idCategoria = idCategoria;
		}

		public List<Integer> getIdsCidades() {
			return idsCidades;
		}

		public void setIdsCidades(List<Integer> idsCidades) {
			this.idsCidades = idsCidades;
		}

		public int getIdEstado() {
			return idEstado;
		}

		public void setIdEstado(int idEstado) {
			this.idEstado = idEstado;
		}
	    
		
	    
}
