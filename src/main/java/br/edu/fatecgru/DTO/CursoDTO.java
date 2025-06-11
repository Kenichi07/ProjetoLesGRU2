package br.edu.fatecgru.DTO;

import br.edu.fatecgru.model.entity.Curso;

public class CursoDTO {
		private Integer id;
	    private String nome;
	    private String descricao;
	    private String linkCurso;
	    private String nomeCategoria;
	
	  	public CursoDTO() {}
		public CursoDTO(Curso c) {
	        id = c.getId();
	        nome = c.getNome();
	        descricao = c.getDescricao();
	        linkCurso = c.getLinkCurso();
	        nomeCategoria = c.getCategoria().getNome();
	    }	
		public CursoDTO(int id, String nome, String descricao, String linkCurso, String nomeCategoria) {
	        this.id = id;
	        this.nome = nome;
	        this.descricao = descricao;
	        this.linkCurso = linkCurso;
	        this.nomeCategoria = nomeCategoria;
	    }
		

		public CursoCadastroDTO toCursoCadastroDTO() {
            return new CursoCadastroDTO(nome, descricao, linkCurso, nomeCategoria);
        }
		
		// Getters e Setters
		public Integer getId() {return id;}
		public void setId(Integer id) {this.id = id;}

		public String getNome() {return nome;}
		public void setNome(String nome) {this.nome = nome;}

		public String getDescricao() {return descricao;}
		public void setDescricao(String descricao) {this.descricao = descricao;}

		public String getLinkCurso() {return linkCurso;}
		public void setLinkCurso(String linkCurso) {this.linkCurso = linkCurso;}

		public String getNomeCategoria() {return nomeCategoria;}
		public void setNomeCategoria(String nomeCategoria) {this.nomeCategoria = nomeCategoria;} 
	}

