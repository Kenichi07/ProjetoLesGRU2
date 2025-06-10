package br.edu.fatecgru.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecgru.model.entity.Categoria;
import br.edu.fatecgru.model.entity.repository.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
    private CategoriaRepository categoriaRepository;
	
	public Optional<Categoria> buscarCategoriaPorId(int id) {
		return categoriaRepository.findById(id);
	}
	
	public Optional<Categoria> buscarPorNome(String nome) {
		return categoriaRepository.findByNome(nome);
	}
	
	public void salvar(Categoria c) {
		categoriaRepository.save(c);
	}
}
