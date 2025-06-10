package br.edu.fatecgru.model.entity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.fatecgru.model.entity.Cidade;
import br.edu.fatecgru.model.entity.Estado;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> { 
	
	public Cidade findByNome(String nome);
	
	public Optional<Cidade> findByNomeAndEstado(String nome, Estado estado);
}