package br.edu.fatecgru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatecgru.DTO.ConsumidorServicoCadastroDTO;
import br.edu.fatecgru.model.entity.ConsumidorServico;
import br.edu.fatecgru.service.ConsumidorService;

//@RestController
@Controller
@RequestMapping("/consumidor")
public class ConsumidorController {

	@Autowired
	private ConsumidorService consumidorService;

	@Autowired
	private UsuarioController usuarioController;
	
	//CADASTRO JA PRONTO - TESTA AI PRA VER SE O CABRA É BOM MESMO
	@PostMapping("/cadastro")
	public String cadastrarConsumidorServico(ConsumidorServicoCadastroDTO dto) {
	    consumidorService.salvar(dto);
		return "redirect:/consumidor/home";
	}
	
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
        return "servicos";
    }
	
	@GetMapping("/servico")
    public String servico() {
        return "servicoindividual";
    }
	
	@GetMapping("/curso")
    public String curso() {
        return "cursoindividualconsu";
    }

	@GetMapping("/perfil")
    public String perfil(Model model) {
		model
		.addAttribute("consumidor", new ConsumidorServico());
        return "perfilconsu";
	}
}
