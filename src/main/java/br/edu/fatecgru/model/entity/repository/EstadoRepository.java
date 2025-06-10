package br.edu.fatecgru.model.entity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.fatecgru.model.entity.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
	
	public Optional<Estado> findByNome(String nome);
}
