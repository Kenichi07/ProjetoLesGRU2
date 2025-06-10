package br.edu.fatecgru.DTO;

public class UsuarioCadastroDTO {
	
	private int id;
	private String nome;
    private String email;
    private String senha;
    private String whatsApp;
    private String papel;
    
    public UsuarioCadastroDTO() {}
	
    public AdministradorCadastroDTO toAdministradorCadastroDTO() {
    	return new AdministradorCadastroDTO(nome,email,senha);	
    }
    
    public UsuarioCadastroDTO(int id, String nome, String email, String senha, String whatsApp, String papel) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.whatsApp = whatsApp;
		this.papel = papel;
	}

	public ConsumidorServicoCadastroDTO toConsumidorServicoCadastroDTO() {
    	return new ConsumidorServicoCadastroDTO(nome,email,senha);	
    }
    
    public PrestadorServicoCadastroDTO toPrestadorServicoCadastroDTO() {
    	return new PrestadorServicoCadastroDTO(nome,email,senha, whatsApp);	
    }
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	
	public String getSenha() {return senha;}
	public void setSenha(String senha) {this.senha = senha;}
	
	public String getWhatsApp() {return whatsApp;}
	public void setWhatsApp(String whatsApp) {this.whatsApp = whatsApp;}

	public String getPapel() {return papel;}
	public void setPapel(String papel) {this.papel = papel;}   
}
