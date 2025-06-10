package br.edu.fatecgru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import br.edu.fatecgru.DTO.ConsumidorServicoCadastroDTO;
import br.edu.fatecgru.model.entity.ConsumidorServico;
import br.edu.fatecgru.model.entity.repository.ConsumidorServicoRepository;

@Service
public class ConsumidorService {

	@Autowired
	private ConsumidorServicoRepository consumidorRepository;
	
	@Lazy
	@Autowired
	private UsuarioService usuarioService;
	 
	public void salvar(ConsumidorServicoCadastroDTO dto) {
	       consumidorRepository.save(dto.toEntity());
	}
	public void salvar(ConsumidorServico entity) {
	       consumidorRepository.save(entity);
	}
}
