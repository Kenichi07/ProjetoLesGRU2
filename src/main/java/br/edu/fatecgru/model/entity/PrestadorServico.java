package br.edu.fatecgru.model.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class PrestadorServico extends Usuario{
	
	@Column(name = "whatsapp")
	private String whatsApp;
	
	@OneToMany(mappedBy = "prestadorservico")
	private List<Servico> servicos;

	public PrestadorServico() {
	}

	public PrestadorServico(String nome, String email, String senha, String whatsApp) {
		super(nome, email, senha);
		this.whatsApp = whatsApp;
	}
	
	//getters n setters
	public String getWhatsApp() {return whatsApp;}
	public void setWhatsApp(String whatsApp) {
		this.whatsApp = whatsApp;
	}

	public List<Servico> getServicos() {return servicos;}
	public void setServicos(List<Servico> servicos) {this.servicos = servicos;}
	
}
