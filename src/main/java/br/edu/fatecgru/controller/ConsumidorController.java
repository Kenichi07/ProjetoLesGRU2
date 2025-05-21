package br.edu.fatecgru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatecgru.service.ConsumidorService;

@RestController
//@Controller
@RequestMapping
public class ConsumidorController {

	@Autowired
	private ConsumidorService consumidorService;
	
}
