package br.edu.fatecgru.model.entity;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class PrestadorServico extends Usuario{
	
	//Atributos
	@Column(name = "whatsapp")
	private String whatsApp;
	@OneToMany(mappedBy = "prestadorservico")
	private List<Servico> servicos;
	
	//Construtores
	public PrestadorServico() {}
	public PrestadorServico(String nome, String email, String senha, String whatsApp) {
		super(nome, email, senha);
		this.whatsApp = whatsApp;
	}
	
	//Getters e Setters
	public String getWhatsApp() {return whatsApp;}
	public void setWhatsApp(String whatsApp) {this.whatsApp = whatsApp;}
	
	

	public List<Servico> getServicos() {return servicos;}
	public void setServicos(List<Servico> servicos) {this.servicos = servicos;}
	
	//Equals e HashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(servicos, whatsApp);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)return true;
		if (!super.equals(obj))return false;
		if (getClass() != obj.getClass())return false;
		PrestadorServico other = (PrestadorServico) obj;
		return Objects.equals(servicos, other.servicos) && Objects.equals(whatsApp, other.whatsApp);
	}		
}
