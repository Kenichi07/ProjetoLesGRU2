package br.edu.fatecgru.model.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.fatecgru.model.entity.PrestadorServico;

@Repository
public interface PrestadorServicoRepository extends JpaRepository<PrestadorServico, Integer> {
	
}
