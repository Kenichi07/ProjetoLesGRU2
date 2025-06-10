package br.edu.fatecgru.DTO;

public class CursoCadastroDTO {
    private String nome;
    private String descricao;
    private String linkCurso;
    private String nomeCategoria;
    
	public CursoCadastroDTO() {	
	}

	public CursoCadastroDTO(String nome, String descricao, String linkCurso, String nomeCategoria) {
		this.nome = nome;
		this.descricao = descricao;
		this.linkCurso = linkCurso;
		this.nomeCategoria = nomeCategoria;
	}
	
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	
	public String getDescricao() {return descricao;}
	public void setDescricao(String descricao) {this.descricao = descricao;}

	public String getLinkCurso() {return linkCurso;}
	public void setLinkCurso(String linkCurso) {this.linkCurso = linkCurso;}

	public String getNomeCategoria() {return nomeCategoria;}
	public void setNomeCategoria(String nomeCategoria) {this.nomeCategoria = nomeCategoria;}
    
	
    

}
