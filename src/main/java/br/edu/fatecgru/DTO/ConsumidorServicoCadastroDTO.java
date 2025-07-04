package br.edu.fatecgru.DTO;

import br.edu.fatecgru.model.entity.ConsumidorServico;

public class ConsumidorServicoCadastroDTO {
	private String nome;
    private String email;
    private String senha;
        
    public ConsumidorServicoCadastroDTO() {}
    
	public ConsumidorServicoCadastroDTO(ConsumidorServico cs) {
    	nome = cs.getNome();
    	email = cs.getEmail();
    	senha = cs.getSenha();    	
    }
    
    
	public ConsumidorServicoCadastroDTO(String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	
	public ConsumidorServico toEntity() {
	    return new ConsumidorServico(nome, email, senha);
	}
	
	//getters n setters
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	
	public String getSenha() {return senha;}
	public void setSenha(String senha) {this.senha = senha;}
}
