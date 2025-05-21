package br.edu.fatecgru.model.entity;

public class Usuario {
	
	private int id;
	private String email;
	private String senha;
	private String tipoUsuario;
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(int id, String email, String senha, String tipoUsuario) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.tipoUsuario = tipoUsuario;
	}

}
