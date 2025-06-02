package br.edu.fatecgru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.fatecgru.model.entity.repository.PrestadorServicoRepository;
import br.edu.fatecgru.model.entity.repository.ServicoRepository;

@Service
public class PrestadorService {

	@Autowired
	private PrestadorServicoRepository prestadorRepository;
	
	 @Autowired
	 private UsuarioService usuarioService;
}
