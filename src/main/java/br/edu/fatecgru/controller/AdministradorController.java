package br.edu.fatecgru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.edu.fatecgru.DTO.LoginDTO;
import br.edu.fatecgru.DTO.UsuarioDTO;
import br.edu.fatecgru.model.entity.Administrador;
import br.edu.fatecgru.model.entity.ConsumidorServico;
import br.edu.fatecgru.model.entity.Curso;
import br.edu.fatecgru.model.entity.PrestadorServico;
import br.edu.fatecgru.model.entity.Usuario;
import br.edu.fatecgru.service.AdministradorService;
import br.edu.fatecgru.service.UsuarioService;
import jakarta.servlet.http.HttpSession;

//@RestController
@Controller
@RequestMapping("/administrador")
public class AdministradorController {

	@Autowired
	private AdministradorService administradorService;

	@Autowired
	private UsuarioController usuarioController;
	
	@Autowired
	private UsuarioService usuarioService;
	
	/*
	 * Consulta de todos usuarios
	 * OBS: Os objetos não tem atributo senha, mas tem um atributo papel = "ADMINISTADOR", "PRESTADOR DE SERVIÇO", "CONSUMIDOR DE SERVICO" ou "DESCONHECIDO"
	 * Mais detalhes em UsuarioDTO 
	 */
	
	@GetMapping("/usuarios")
	public List<UsuarioDTO> listarTodosUsuarios() {
	    return administradorService.listarTodosUsuarios();
	}
	
	@PostMapping("/logar")
	public String logar(@ModelAttribute LoginDTO dto, HttpSession session) {
		Usuario usuario = usuarioService.autenticarUsuario(dto);

		if (usuario != null) {
			session.setAttribute("usuarioLogado", usuario); // guarda na sessão
	        if (usuario instanceof Administrador) {
	            return "redirect:/administrador/home";
	        } else if (usuario instanceof PrestadorServico) {
	            return "redirect:/prestador/home";
	        } else if (usuario instanceof ConsumidorServico) {
	            return "redirect:/consumidor/home";
	        }
	    }
		return null;
    }
	
	@GetMapping("/login")
    public String loginPage(Model model) {
		model.addAttribute("LoginDTO", new LoginDTO());
        return "login";
    }
	
	@GetMapping("/cadastro")
    public String cadastroPage(Model model) {
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
    public String home(HttpSession session, Model model) {
		Administrador admin = (Administrador) session.getAttribute("usuarioLogado");
	    model.addAttribute("admin", admin);
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
	
	@GetMapping("/new") 
	public String newServico(Model model) { 
  		model
  			.addAttribute("curso", new Curso())
  			.addAttribute("novo", true); 
  		return "formadm"; 
	}		
	  
	@GetMapping("/perfil")
    public String perfil(HttpSession session, Model model) {
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");

	    if (usuario == null) {
	        return "redirect:/login"; // redireciona se não estiver logado
	    }

	    model.addAttribute("usuario", usuario); // envia os dados para a view
        return "perfiladm";
	}
}
