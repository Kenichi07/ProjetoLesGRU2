package br.edu.fatecgru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.fatecgru.model.entity.repository.ConsumidorServicoRepository;
import br.edu.fatecgru.model.entity.repository.ServicoRepository;

@Service
public class ConsumidorService {

	@Autowired
	private ConsumidorServicoRepository consumidorRepository;
	
	 @Autowired
	    private UsuarioService usuarioService;
}
