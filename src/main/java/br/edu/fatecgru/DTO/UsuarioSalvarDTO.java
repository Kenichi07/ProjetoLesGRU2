package br.edu.fatecgru.DTO;

import br.edu.fatecgru.model.entity.Administrador;
import br.edu.fatecgru.model.entity.ConsumidorServico;
import br.edu.fatecgru.model.entity.PrestadorServico;
import br.edu.fatecgru.model.entity.Usuario;

public class UsuarioSalvarDTO {
		private int id;
		private String nome;
		private String email;
		private String senha;
		private String whatsapp;
		private String papel;
		
		public UsuarioSalvarDTO() {}
		
		public UsuarioSalvarDTO(int id, String nome, String email, String senha, String whatsapp, String papel) {
			super();
			this.id = id;
			this.nome = nome;
			this.email = email;
			this.senha = senha;
			this.whatsapp = whatsapp;
			this.papel = papel;
		}

		public UsuarioSalvarDTO(Usuario u) {
			id = u.getId();
			nome = u.getNome();
			email = u.getEmail();
				
			if (u instanceof Administrador) {
	            papel = "ADMINISTRADOR";
	        } else if (u instanceof PrestadorServico) {
	        	papel = "PRESTADOR DE SERVICO";
	        } else if (u instanceof ConsumidorServico) {
	        	papel = "CONSUMIDOR DE SERVICO";
	        } else {
	            papel = "DESCONHECIDO";
	        }
		}
		
		//getters e setters
		public int getId() {return id;}
		public void setId(int id) {this.id = id;	}

		public String getNome() {return nome;}
		public void setNome(String nome) {this.nome = nome;}

		public String getEmail() {return email;}
		public void setEmail(String email) {this.email = email;}

		public String getPapel() {return papel;}
		public void setPapel(String papel) {this.papel = papel;}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}

		public String getWhatsapp() {
			return whatsapp;
		}

		public void setWhatsapp(String whatsapp) {
			this.whatsapp = whatsapp;
		}
		
		
}
