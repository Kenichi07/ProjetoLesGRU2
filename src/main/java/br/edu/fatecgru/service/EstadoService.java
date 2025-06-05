package br.edu.fatecgru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecgru.model.entity.Estado;
import br.edu.fatecgru.model.entity.repository.EstadoRepository;

@Service
public class EstadoService {
	@Autowired
    private EstadoRepository estadoRepository;
	
	public Estado buscarEstadoPorId(int id) {
		return estadoRepository.findById(id).get();
	}
}
