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
	
	@GetMapping("/buscar/cidade")
	public ResponseEntity<List<ServicoDTO>> buscarPorNomeCidade(@RequestParam String nomeCidade) {
	    List<ServicoDTO> servicos = servicoService.buscarServicoPorNomeCidade(nomeCidade);
	    return ResponseEntity.ok(servicos);
	}

	@GetMapping("/buscar/estado")
	public ResponseEntity<List<ServicoDTO>> buscarPorNomeEstado(@RequestParam String nomeEstado) {
	    List<ServicoDTO> servicos = servicoService.buscarServicoPorNomeEstado(nomeEstado);
	    return ResponseEntity.ok(servicos);
	}

}
