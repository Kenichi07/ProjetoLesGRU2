package br.edu.fatecgru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatecgru.DTO.ServicoDTO;
import br.edu.fatecgru.service.ServicoService;

@RestController
@RequestMapping("/servicos")
public class ServicoController {
	@Autowired
	private ServicoService servicoService;

	@GetMapping("/todos")
	public List<ServicoDTO> listarTodosServicos() {
	    return servicoService.buscarTodosServico();
	    
	}
	
	
	//Reformular
	
	@GetMapping("/cidade/{idCidade}")
	public List<ServicoDTO> buscarPorCidade(@PathVariable int idCidade) {
		return  servicoService.buscarServicoPorCidade(idCidade);
	    
	}
	
	@GetMapping("/estado/{idEstado}")
	public List<ServicoDTO> buscarPorEstado(@PathVariable int idEstado) {
		return servicoService.buscarServicoPorEstado(idEstado);
	    
	}

}
