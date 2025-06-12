package br.edu.fatecgru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatecgru.DTO.ConsumidorServicoCadastroDTO;
import br.edu.fatecgru.DTO.CursoDTO;
import br.edu.fatecgru.DTO.CursoSelectDTO;
import br.edu.fatecgru.DTO.ServicoCadastroDTO;
import br.edu.fatecgru.DTO.ServicoDTO;
import br.edu.fatecgru.DTO.ServicoSelectDTO;
import br.edu.fatecgru.DTO.UsuarioCadastroDTO;
import br.edu.fatecgru.model.entity.Administrador;
import br.edu.fatecgru.model.entity.ConsumidorServico;
import br.edu.fatecgru.model.entity.Curso;
import br.edu.fatecgru.model.entity.CursoFavorito;
import br.edu.fatecgru.model.entity.PrestadorServico;
import br.edu.fatecgru.model.entity.ServicoFavorito;
import br.edu.fatecgru.service.ConsumidorService;
import br.edu.fatecgru.service.CursoFavoritoService;
import br.edu.fatecgru.service.CursoService;
import br.edu.fatecgru.service.PrestadorService;
import br.edu.fatecgru.service.ServicoFavoritoService;
import br.edu.fatecgru.service.ServicoService;
import br.edu.fatecgru.service.UsuarioService;
import jakarta.persistence.Id;
import jakarta.servlet.http.HttpSession;

//@RestController
@Controller
@RequestMapping("/consumidor")
public class ConsumidorController {

	@Autowired
	private ConsumidorService consumidorService;

	@Autowired
	private UsuarioController usuarioController;
	
	@Autowired
	private CursoService cursoService;
	
	@Autowired
	private CursoFavoritoService cursoFservice;
	
	@Autowired
	private ServicoService servicoService;
	
	@Autowired
	private ServicoFavoritoService servicoFservice;
	
	@Autowired
	private PrestadorService prestadorService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	//CADASTRO JA PRONTO - TESTA AI PRA VER SE O CABRA É BOM MESMO
	@PostMapping("/cadastro")
	public String cadastrarConsumidorServico(ConsumidorServicoCadastroDTO dto) {
	    consumidorService.salvar(dto);
		return "redirect:/consumidor/home";
	}
	
	@GetMapping("/sair")
	public String sair() {
		return "index";
	}
	
	@PostMapping("save")
	public String salvar(@ModelAttribute UsuarioCadastroDTO dto, HttpSession session, Model model) {
		usuarioService.atualizarUsuario(dto);
		ConsumidorServico adm = (ConsumidorServico) session.getAttribute("usuarioLogado");
	    model.addAttribute("admin", adm);
	    return "redirect:/consumidor/home";
	}
	
	@GetMapping("/home")
    public String home(HttpSession session, Model model) {
		ConsumidorServico consu = (ConsumidorServico) session.getAttribute("usuarioLogado");
		List<ServicoSelectDTO> servicos = servicoService.buscarServicosMaisBaratos2(consu.getId());
		List<ServicoSelectDTO> servicoF = servicoFservice.listarServicosFavoritosPorUsuario(consu.getId());
	    model.addAttribute("consu", consu);
	    model.addAttribute("servicos",servicos);
	    model.addAttribute("servicoF", servicoF);
        return "homeconsumidor";
    }

	@GetMapping("/educacional")
    public String educacional(HttpSession session, Model model) {
		ConsumidorServico consumidor = (ConsumidorServico) session.getAttribute("usuarioLogado");
		List<CursoSelectDTO> curso = cursoService.buscarOitoPrimeirosCursosNaoFavoritados(consumidor.getId());
		List<CursoSelectDTO> cursoF = cursoFservice.listarCursosFavoritosPorUsuario(consumidor.getId());
	    model.addAttribute("consumidor", consumidor);
		model.addAttribute("cursos", curso);
		model.addAttribute("cursoF", cursoF);
        return "educacionalconsu";
    }
	
	@GetMapping("/catalogo")
    public String catalogo(HttpSession session, Model model) {
		ConsumidorServico consu = (ConsumidorServico) session.getAttribute("usuarioLogado");
		List<ServicoSelectDTO> servicos = servicoFservice.buscarTodosServicos(consu.getId());
	    model.addAttribute("consu", consu);
	    model.addAttribute("servicos",servicos);
        return "catalogo";
    }
	
	@GetMapping("/equipe")
    public String equipe(HttpSession session, Model model) {
		ConsumidorServico consu = (ConsumidorServico) session.getAttribute("usuarioLogado");
	    model.addAttribute("consu", consu);
        return "equipeconsu";
	}
	
	@GetMapping("/cursos")
    public String cursos(HttpSession session, Model model) {
		ConsumidorServico consumidor = (ConsumidorServico) session.getAttribute("usuarioLogado");
		List<CursoSelectDTO> curso = cursoFservice.buscarTodosCursos(consumidor.getId());
	    model.addAttribute("consumidor", consumidor);
		model.addAttribute("cursos", curso);
        return "cursoconsu";
    }
	
	@GetMapping("/{id}/servico")
    public String servico(HttpSession session, Model model, @PathVariable int id) {
		ServicoDTO dto = servicoService.buscarServicoDTOPorId(id);
		ConsumidorServico consumidor = (ConsumidorServico) session.getAttribute("usuarioLogado");
	    model.addAttribute("consumidor", consumidor);
	    model.addAttribute("dto", dto);
        return "servicoindividual";
    }
	
	@GetMapping("/{id}/curso")
    public String curso(HttpSession session, Model model, @PathVariable int id) {
		ConsumidorServico consumidor = (ConsumidorServico) session.getAttribute("usuarioLogado");
	    model.addAttribute("consumidor", consumidor);
	    model.addAttribute("curso", cursoService.buscarPorId(id));
        return "cursoindividualconsu";
    }

	@GetMapping("/perfil")
    public String perfil(HttpSession session, Model model) {
		ConsumidorServico consumidor = (ConsumidorServico) session.getAttribute("usuarioLogado");
		model.addAttribute("consumidor", consumidor);
        return "perfilconsu";
	}

	@GetMapping("/{id}/favoritar")
    public String favoritar(HttpSession session, Model model, @PathVariable int id) {
		ConsumidorServico consumidor = (ConsumidorServico) session.getAttribute("usuarioLogado");
		cursoFservice.favoritar(consumidor.getId(), id);
	    model.addAttribute("consumidor", consumidor);
        return "redirect:/consumidor/educacional";
	}
	
	@GetMapping("/{id}/desfavoritar")
    public String desfavoritar(HttpSession session, Model model, @PathVariable int id) {
		ConsumidorServico consumidor = (ConsumidorServico) session.getAttribute("usuarioLogado");
		cursoFservice.desfavoritar(consumidor.getId(), id);
	    model.addAttribute("consumidor", consumidor);
        return "redirect:/consumidor/educacional";
	}
	
	@GetMapping("/{id}/favoritarServico")
    public String favoritarServico(HttpSession session, Model model, @PathVariable int id) {
		ConsumidorServico consumidor = (ConsumidorServico) session.getAttribute("usuarioLogado");
		servicoFservice.favoritar(consumidor.getId(), id);
	    model.addAttribute("consumidor", consumidor);
        return "redirect:/consumidor/home";
	}
	
	@GetMapping("/{id}/desfavoritarServico")
    public String desfavoritarServico(HttpSession session, Model model, @PathVariable int id) {
		ConsumidorServico consumidor = (ConsumidorServico) session.getAttribute("usuarioLogado");
		servicoFservice.desfavoritar(consumidor.getId(), id);
	    model.addAttribute("consumidor", consumidor);
        return "redirect:/consumidor/home";
	}
	
	@GetMapping("/buscar")
	public String buscarPorNome(@RequestParam("nome") String nome, HttpSession session, Model model) {
		ConsumidorServico consumidor = (ConsumidorServico) session.getAttribute("usuarioLogado");
		List<CursoSelectDTO> cursos = cursoService.buscarPorNomeOuCategoria(nome, consumidor.getId());
		model.addAttribute("consumidor", consumidor);
		model.addAttribute("cursos", cursos);
		return "cursoconsu";
	}
	
	@GetMapping("/buscarServico")
	public String buscarPorNomeServico(@RequestParam("nome") String nome, HttpSession session, Model model) {
		ConsumidorServico consumidor = (ConsumidorServico) session.getAttribute("usuarioLogado");
		List<ServicoSelectDTO> servicos = servicoService.buscarServicoPorNome(nome, consumidor.getId());
		model.addAttribute("prestador", consumidor);
		model.addAttribute("servicos", servicos);
		return "catalogo";
	}
}
