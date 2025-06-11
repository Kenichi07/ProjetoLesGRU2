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
import br.edu.fatecgru.service.CursoFavoritoService;
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
	
	@Autowired
	private CursoFavoritoService cursoFservice;
	
	@Autowired CategoriaService categoriaService;
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/sair")
	public String sair() {
		return "index";
	}
	
	@GetMapping("/usuarios")
	public String listarTodosUsuarios(HttpSession session, Model model) {
		Administrador admin = (Administrador) session.getAttribute("usuarioLogado");
		List<UsuarioDTO> usuarios = administradorService.listarTodosUsuarios(admin.getId());
	    model.addAttribute("admin", admin);
		model.addAttribute("usuarios", usuarios);
		return "homeadministrador";
	}
	
	@GetMapping("/{id}/delete")
	public String deletarUsuario(HttpSession session, Model model, @PathVariable int id) {
		usuarioService.deletarUsuario(id);
		Administrador adm = (Administrador) session.getAttribute("usuarioLogado");
	    model.addAttribute("admin", adm);
		return "redirect:/administrador/usuarios";
	}
	
	@GetMapping("/{id}/edit")
	public String editarUsuario(HttpSession session, Model model, @PathVariable int id) {
		Administrador adm = (Administrador) session.getAttribute("usuarioLogado");
	    model.addAttribute("admin", adm);
	    model.addAttribute("usuario", administradorService.buscarUsuarioPorId(id));
	    model.addAttribute("novo", false);
		return "formusuario";
	}
	
	@GetMapping("/{id}/deleteCurso")
	public String deletarCurso(HttpSession session, Model model, @PathVariable int id) {
		cursoService.deletarCurso(id);
		Administrador adm = (Administrador) session.getAttribute("usuarioLogado");
	    model.addAttribute("admin", adm);
		return "redirect:/administrador/educacional";
	}
	
	@GetMapping("/{id}/editCurso")
	public String editarCurso(HttpSession session, Model model, @PathVariable int id) {
		Administrador adm = (Administrador) session.getAttribute("usuarioLogado");
	    model.addAttribute("admin", adm);
	    model.addAttribute("cursoDTO", cursoService.buscarPorId(id));
	    model.addAttribute("novo", false);
		return "formadm";
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
		if (dto.getId() == null) {
			dto.setPapel("ADMINISTRADOR");
			usuarioService.cadastrarUsuario(dto);
		} else {			
			usuarioService.atualizarUsuario(dto);
		}
		Administrador adm = (Administrador) session.getAttribute("usuarioLogado");
	    model.addAttribute("admin", adm);
	    return "redirect:/administrador/usuarios";
	}
	
	@PostMapping("saveCurso")
	public String salvarCurso(@ModelAttribute CursoDTO dto, HttpSession session, Model model) {
		Administrador adm = (Administrador) session.getAttribute("usuarioLogado");
	    model.addAttribute("admin", adm);
	    
	    if (dto.getId() == null) {
	        // Cadastro novo
	        cursoService.salvarCurso(dto.toCursoCadastroDTO());;
	    } else {
	        // Atualização
	    	cursoService.atualizarCurso(dto);
	    }
		return "redirect:/administrador/educacional";
	}
	
	//CADASTRO JA PRONTO - TESTA AI PRA VER SE O CABRA É BOM MESMO (só não esquece de att os imports)
	
	@PostMapping("/cadastro")
	public String cadastrarAdministrador(@ModelAttribute UsuarioCadastroDTO dto, HttpSession session) {
	    Usuario usuario = usuarioService.cadastrarUsuario(dto);
	    
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
  			.addAttribute("usuario", new UsuarioCadastroDTO())
  			.addAttribute("admin", admin)
  			.addAttribute("novo", true); 
  		return "formusuario"; 
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
