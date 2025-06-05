package br.edu.fatecgru.DTO;

import br.edu.fatecgru.model.entity.PrestadorServico;

public class PrestadorServicoCadastroDTO {
	private String nome;
    private String email;
    private String senha;
    private String whatsApp;
    
    public PrestadorServicoCadastroDTO(PrestadorServico ps) {
		nome = ps.getNome();
		email = ps.getEmail();
		senha = ps.getSenha();
		whatsApp = ps.getWhatsApp();
	}
    

	public PrestadorServicoCadastroDTO(String nome, String email, String senha, String whatsapp) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.whatsApp = whatsapp;
	}

	public PrestadorServico toEntity() {
	    return new PrestadorServico(nome, email, senha, whatsApp);
	}
	
	//getters n setters
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}

	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}

	public String getSenha() {return senha;}
	public void setSenha(String senha) {this.senha = senha;}
	
	public String getWhatsApp() {return whatsApp;}
	public void setWhatsApp(String whatsApp) {this.whatsApp = whatsApp;}
    
    
}
