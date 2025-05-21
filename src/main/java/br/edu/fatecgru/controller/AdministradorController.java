package br.edu.fatecgru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatecgru.service.AdministradorService;

@RestController
//@Controller
@RequestMapping
public class AdministradorController {

	@Autowired
	private AdministradorService administradorService;
	
}
