package br.edu.fatecgru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecgru.model.entity.Cidade;
import br.edu.fatecgru.model.entity.Estado;
import br.edu.fatecgru.model.entity.repository.CidadeRepository;

@Service
public class CidadeService {
	@Autowired
    private CidadeRepository cidadeRepository;
	
	public Cidade buscarCidadePorId(int id) {
		return cidadeRepository.findById(id).get();
	}
	
	public Cidade buscarCidadePorNome(String nome) {
		return cidadeRepository.findByNome(nome).get();
	}
	
	public List<Cidade> buscarTodasCidadesPorId(List<Integer> idsCidades){
		return cidadeRepository.findAllById(idsCidades);
		
	}
}
