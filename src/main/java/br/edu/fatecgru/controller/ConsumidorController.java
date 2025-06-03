package br.edu.fatecgru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.fatecgru.service.ConsumidorService;

//@RestController
@Controller
@RequestMapping("/consumidor")
public class ConsumidorController {

	@Autowired
	private ConsumidorService consumidorService;

	@Autowired
	private UsuarioController usuarioController;
	
	@GetMapping("/home")
    public String home() {
        return "homeconsumidor";
    }

	@GetMapping("/educacional")
    public String educacional() {
        return "educacionalconsu";
    }
	
	@GetMapping("/catalogo")
    public String catalogo() {
        return "catalogo";
    }
	
	@GetMapping("/equipe")
    public String equipe() {
        return "equipeconsu";
	}
	
	@GetMapping("/cursos")
    public String cursos() {
        return "cursoconsu";
    }
	
	@GetMapping("/servicos")
    public String servicos() {
        return "servico";
    }
	

	@GetMapping("/prefil")
    public String perfil() {
        return "meuperfil";
	}
}
