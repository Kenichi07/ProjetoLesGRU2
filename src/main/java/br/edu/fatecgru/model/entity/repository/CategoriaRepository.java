package br.edu.fatecgru.model.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.fatecgru.model.entity.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> { 
	
	public Categoria findByNome(String nomeCategoria);
}
