package br.edu.fatecgru.model.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;

@Entity
public class ConsumidorServico extends Usuario{

	@ManyToMany
    @JoinTable(
        name = "SERVICOS_FAVORITOS",
        joinColumns = @JoinColumn(name = "SEFA_CON_USU_id"),
        inverseJoinColumns = @JoinColumn(name = "SEFA_SER_id")
    )
    private List<Servico> servicosFavoritos;

	public ConsumidorServico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConsumidorServico(int id, String nome, String email, String senha, List<Curso> cursosFavoritos) {
		super(id, nome, email, senha, cursosFavoritos);
		// TODO Auto-generated constructor stub
	}

	public List<Servico> getServicosFavoritos() {
		return servicosFavoritos;
	}

	public void setServicosFavoritos(List<Servico> servicosFavoritos) {
		this.servicosFavoritos = servicosFavoritos;
	}

}