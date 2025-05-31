package br.edu.fatecgru.model.entity;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class PrestadorServico extends Usuario{

	private String Whatsapp;
	
	@OneToMany(mappedBy = "prestadorservico")
	private List<Servico> servicos;

	public PrestadorServico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PrestadorServico(int id, String nome, String email, String senha, List<Curso> cursosFavoritos) {
		super(id, nome, email, senha, cursosFavoritos);
		// TODO Auto-generated constructor stub
	}

	public String getWhatsapp() {
		return Whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		Whatsapp = whatsapp;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}
	
}
