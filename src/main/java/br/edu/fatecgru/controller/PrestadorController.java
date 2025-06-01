package br.edu.fatecgru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.edu.fatecgru.service.PrestadorService;

//@RestController
@Controller
@RequestMapping("/prestador")
public class PrestadorController {

	@Autowired
	private PrestadorService prestadorService;
	
	@GetMapping("/home")
    public String home() {
        return "homeconsumidor";
    }

	@GetMapping("/educacional")
    public String educacional() {
        return "educacional";
    }
	
	@GetMapping("/equipe")
    public String equipe() {
        return "equipe";
	}
}
