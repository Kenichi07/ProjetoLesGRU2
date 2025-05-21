package br.edu.fatecgru.model.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.fatecgru.model.entity.Prestador;

@Repository
public interface PrestadorRepository extends JpaRepository<Prestador, Integer> {
	
}
