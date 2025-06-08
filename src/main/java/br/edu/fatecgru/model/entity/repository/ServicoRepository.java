package br.edu.fatecgru.model.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.fatecgru.model.entity.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {
	
	List<Servico> findByPrestadorservicoId(int idPrestador);
}
