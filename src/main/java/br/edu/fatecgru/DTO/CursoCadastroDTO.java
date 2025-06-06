package br.edu.fatecgru.DTO;

public class CursoCadastroDTO {
    private String nome;
    private String descricao;
    private String linkCurso;
    private int idCategoria;
    
	public CursoCadastroDTO() {	
	}

	public CursoCadastroDTO(String nome, String descricao, String linkCurso, int idCategoria) {
		this.nome = nome;
		this.descricao = descricao;
		this.linkCurso = linkCurso;
		this.idCategoria = idCategoria;
	}
	
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	
	public String getDescricao() {return descricao;}
	public void setDescricao(String descricao) {this.descricao = descricao;}

	public String getLinkCurso() {return linkCurso;}
	public void setLinkCurso(String linkCurso) {this.linkCurso = linkCurso;}

	public int getIdCategoria() {return idCategoria;}
	public void setIdCategoria(int idCategoria) {this.idCategoria = idCategoria;}
    
	
    

}
