package br.edu.fatecgru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatecgru.DTO.UsuarioDTO;
import br.edu.fatecgru.model.entity.Curso;
import br.edu.fatecgru.service.AdministradorService;
import org.springframework.ui.Model;

@RestController
//@Controller
@RequestMapping("/administrador")
public class AdministradorController {

	@Autowired
	private AdministradorService administradorService;

	@Autowired
	private UsuarioController usuarioController;
	
	/*
	 * Consulta de todos usuarios
	 * OBS: Os objetos não tem atributo senha, mas tem um atributo papel = "ADMINISTADOR", "PRESTADOR DE SERVIÇO", "CONSUMIDOR DE SERVICO" ou "DESCONHECIDO"
	 * Mais detalhes em UsuarioDTO 
	 */
	
	@GetMapping("/usuarios")
	public List<UsuarioDTO> listarTodosUsuarios() {
	    return administradorService.listarTodosUsuarios();
	}

	
	@GetMapping("/login")
    public String loginPage() {
        return "login";
    }
	
	@GetMapping("/cadastro")
    public String cadastroPage() {
        return "cadastro";
    }
	
	//CADASTRO JA PRONTO - TESTA AI PRA VER SE O CABRA É BOM MESMO (só não esquece de att os imports)
	/*
	@PostMapping("/cadastro")
	public void cadastrarAdministrador(@RequestBody AdministradorCadastroDTO dto) {
	    administradorService.salvar(dto);
	}*/
	
	@GetMapping("/cadastroadm")
    public String cadastroAdmPage() {
        return "cadastroadm";
    }
	
	@GetMapping("/home")
    public String home() {
        return "homeadministrador";
    }

	@GetMapping("/educacional")
    public String educacional() {
        return "educacionaladm";
    }
	
	@GetMapping("/equipe")
    public String equipe() {
        return "equipeadm";
	}
	
	  @GetMapping("/new") public String newServico(Model model) { 
	  		model
	  			.addAttribute("curso", new Curso())
	  			.addAttribute("novo", true); 
	  		return "formadm"; 
	  }		
}
