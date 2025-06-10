package br.edu.fatecgru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecgru.model.entity.Categoria;
import br.edu.fatecgru.model.entity.repository.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
    private CategoriaRepository categoriaRepository;
	
	public Categoria buscarCategoriaPorId(int id) {
		return categoriaRepository.findById(id).get();
	}
	
	public Categoria buscarPorNome(String nome) {
		return categoriaRepository.findByNome(nome).get();
	}
}
