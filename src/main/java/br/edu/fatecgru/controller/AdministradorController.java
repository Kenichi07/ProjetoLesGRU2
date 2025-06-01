package br.edu.fatecgru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatecgru.service.AdministradorService;

//@RestController
@Controller
@RequestMapping("/administrador")
public class AdministradorController {

	@Autowired
	private AdministradorService administradorService;

	@GetMapping("/login")
    public String loginPage() {
        return "homeconsumidor";
    }
	
	@GetMapping("/cadastro")
    public String cadastroPage() {
        return "cadastro";
    }
	
	@GetMapping("/cadastroadm")
    public String cadastroAdmPage() {
        return "cadastroadm";
    }
	
}