package br.edu.fatecgru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatecgru.service.PrestadorService;

@RestController
//@Controller
@RequestMapping
public class PrestadorController {

	@Autowired
	private PrestadorService prestadorService;
	
	@Autowired
	private UsuarioController usuarioController;
}
