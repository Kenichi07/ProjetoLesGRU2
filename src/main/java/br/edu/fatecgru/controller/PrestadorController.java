package br.edu.fatecgru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.fatecgru.model.entity.Servico;
import br.edu.fatecgru.service.PrestadorService;

//@RestController
@Controller
@RequestMapping("/prestador")
public class PrestadorController {

	@Autowired
	private PrestadorService prestadorService;
	
	@Autowired
	private UsuarioController usuarioController;

	@GetMapping("/home")
    public String home() {
        return "homeprestador";
    }

	@GetMapping("/educacional")
    public String educacional() {
        return "educacionalpresta";
    }
	
	@GetMapping("/equipe")
    public String equipe() {
        return "equipepresta";
	}
	
	@GetMapping("/cursos")
    public String cursos() {
        return "cursopresta";
    }
	
	@GetMapping("/list")
    public String meusServicos() {
        return "meusServicos";
	}
	
	@GetMapping("/new")
	public String newBrinquedo(Model model) {
		model
			.addAttribute("servico", new Servico())
			.addAttribute("novo", true);
		return "formpresta";
	}
}
