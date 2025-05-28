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
	
}