package br.edu.fatecgru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.edu.fatecgru.DTO.CursoCadastroDTO;
import br.edu.fatecgru.DTO.CursoDTO;
import br.edu.fatecgru.DTO.LoginDTO;
import br.edu.fatecgru.DTO.PrestadorServicoCadastroDTO;
import br.edu.fatecgru.DTO.UsuarioCadastroDTO;
import br.edu.fatecgru.DTO.UsuarioDTO;
import br.edu.fatecgru.model.entity.Administrador;
import br.edu.fatecgru.model.entity.Categoria;
import br.edu.fatecgru.model.entity.ConsumidorServico;
import br.edu.fatecgru.model.entity.Curso;
import br.edu.fatecgru.model.entity.PrestadorServico;
import br.edu.fatecgru.model.entity.Usuario;
import br.edu.fatecgru.service.AdministradorService;
import br.edu.fatecgru.service.CategoriaService;
import br.edu.fatecgru.service.CursoService;
import br.edu.fatecgru.service.UsuarioService;
import jakarta.servlet.http.HttpSession;

//RestController
@Controller
@RequestMapping("/administrador")
public class AdministradorController {

	@Autowired
	private AdministradorService administradorService;

	@Autowired
	private UsuarioController usuarioController;
	
	@Lazy
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private CursoService cursoService;
	
	@Autowired CategoriaService categoriaService;
	
	
	@GetMapping("/usuarios")
	public String listarTodosUsuarios(HttpSession session, Model model) {
		List<UsuarioDTO> usuarios = administradorService.listarTodosUsuarios();
		Administrador admin = (Administrador) session.getAttribute("usuarioLogado");
	    model.addAttribute("admin", admin);
		model.addAttribute("usuarios", usuarios);
		return "homeadministrador";
	}
	
	@GetMapping("/{id}/delete")
	public String deletarUsuario(@PathVariable int id) {
		usuarioService.deletarUsuario(id);
		return "redirect:/administrador/usuarios";
	}
	
	@GetMapping("/{id}/edit")
	public String editarUsuario(HttpSession session, Model model, @PathVariable int id) {
		Administrador adm = (Administrador) session.getAttribute("usuarioLogado");
	    model.addAttribute("admin", adm);
	    model.addAttribute("usuarioDTO", administradorService.buscarUsuarioPorId(id));
		return "formusuario";
	}
	
	/*
	@GetMapping("/{id}/edit")
	public String editarCurso(Model model, @PathVariable int id) {
		Categoria categoria = categoriaService.buscarCategoriaPorId(id);
		 
		return "formadm";
	}*/
	
	@GetMapping("/login")
    public String loginPage(Model model) {
		model.addAttribute("LoginDTO", new LoginDTO());
        return "login";
    }
	
	@GetMapping("/cadastro")
    public String cadastroPage(Model model) {
		model.addAttribute("usuarioCadastroDTO", new UsuarioCadastroDTO());
        return "cadastro";
    }
	
	//Esse trem é aqui mesmo nessa controller?
	@PostMapping("/logar")
	public String logar(@ModelAttribute LoginDTO dto, HttpSession session) {
		Usuario usuario = usuarioService.autenticarUsuario(dto);

		if (usuario != null) {
			session.setAttribute("usuarioLogado", usuario); // guarda na sessão
	        if (usuario instanceof Administrador) {
	            return "redirect:/administrador/usuarios";
	        } else if (usuario instanceof PrestadorServico) {
	            return "redirect:/prestador/home";
	        } else if (usuario instanceof ConsumidorServico) {
	            return "redirect:/consumidor/home";
	        }
	    }
		return null;
    }
	
	@PostMapping("save")
	public String salvar(@ModelAttribute UsuarioCadastroDTO dto, HttpSession session, Model model) {
		usuarioService.cadastrarUsuario(dto);
		Administrador adm = (Administrador) session.getAttribute("usuarioLogado");
	    model.addAttribute("admin", adm);
		return "redirect:/administrador/usuarios";
	}
	
	//CADASTRO JA PRONTO - TESTA AI PRA VER SE O CABRA É BOM MESMO (só não esquece de att os imports)
	
	@PostMapping("/cadastro")
	public String cadastrarAdministrador(@ModelAttribute UsuarioCadastroDTO dto, HttpSession session) {
	    Usuario usuario = usuarioService.cadastrarUsuario(dto);
	    
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
	
	@GetMapping("/cadastroadm")
    public String cadastroAdmPage() {
        return "cadastroadm";
    }
	
	/*
	@GetMapping("/home")
    public String home(HttpSession session, Model model) {
		Administrador admin = (Administrador) session.getAttribute("usuarioLogado");
	    model.addAttribute("admin", admin);
        return "homeadministrador";
    }*/

	@GetMapping("/educacional")
    public String educacional(HttpSession session, Model model) {
		List<CursoDTO> curso = cursoService.listarTodosCursos();
		Administrador admin = (Administrador) session.getAttribute("usuarioLogado");
	    model.addAttribute("admin", admin);
		model.addAttribute("cursos", curso);
        return "educacionaladm";
    }
	
	@GetMapping("/equipe")
    public String equipe(HttpSession session, Model model) {
		Administrador admin = (Administrador) session.getAttribute("usuarioLogado");
	    model.addAttribute("admin", admin);
        return "equipeadm";
	}
	
	@GetMapping("/new") 
	public String newCurso(HttpSession session, Model model) { 
		Administrador admin = (Administrador) session.getAttribute("usuarioLogado");
	    model.addAttribute("admin", admin);
  		model
  			.addAttribute("cursoDTO", new CursoDTO())
  			.addAttribute("admin", admin)
  			.addAttribute("novo", true); 
  		return "formadm"; 
	}
	
	@GetMapping("/newUsuario") 
	public String newUsuario(HttpSession session, Model model) { 
		Administrador admin = (Administrador) session.getAttribute("usuarioLogado");
	    model.addAttribute("admin", admin);
  		model
  			.addAttribute("usuarioDTO", new UsuarioDTO())
  			.addAttribute("admin", admin)
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
