package br.edu.fatecgru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/listar_todos")
	public List<ServicoDTO> listarTodosServicos() {
	    return servicoService.buscarTodosServico();
	    
	}
	
	//Reformular
	/*
	@GetMapping("/buscar/cidade")
	public List<ServicoDTO> buscarPorNomeCidade(@RequestParam String nomeCidade) {
		return  servicoService.buscarServicoPorNomeCidade(nomeCidade);
	    
	}

	@GetMapping("/buscar/estado")
	public List<ServicoDTO> buscarPorNomeEstado(@RequestParam String nomeEstado) {
		return servicoService.buscarServicoPorNomeEstado(nomeEstado);
	    
	}*/

}
