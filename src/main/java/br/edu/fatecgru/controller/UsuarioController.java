package br.edu.fatecgru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatecgru.service.UsuarioService;

@RestController
//@Controller
@RequestMapping
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

}
