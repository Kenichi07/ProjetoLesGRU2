package br.edu.fatecgru.DTO;

import br.edu.fatecgru.model.entity.Administrador;

public class AdministradorCadastroDTO {
	private String nome;
    private String email;
    private String senha;
    
    public AdministradorCadastroDTO(Administrador a) {
		nome = a.getNome();
		email = a.getEmail();
		senha = a.getSenha();
	}

    public Administrador toEntity() {
	    return new Administrador(nome, email, senha);
	}
    
    
    //getters n setters
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}

	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}

	public String getSenha() {return senha;}
	public void setSenha(String senha) {this.senha = senha;}
    
    
}
