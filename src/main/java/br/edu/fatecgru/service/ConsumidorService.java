package br.edu.fatecgru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.fatecgru.model.entity.repository.ConsumidorRepository;

@Service
public class ConsumidorService {

	@Autowired
	private ConsumidorRepository consumidorRepository;
	
}
