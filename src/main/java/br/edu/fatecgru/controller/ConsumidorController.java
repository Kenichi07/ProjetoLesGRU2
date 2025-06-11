package br.edu.fatecgru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatecgru.DTO.ConsumidorServicoCadastroDTO;
import br.edu.fatecgru.DTO.CursoDTO;
import br.edu.fatecgru.DTO.ServicoCadastroDTO;
import br.edu.fatecgru.DTO.ServicoDTO;
import br.edu.fatecgru.model.entity.Administrador;
import br.edu.fatecgru.model.entity.ConsumidorServico;
import br.edu.fatecgru.model.entity.CursoFavorito;
import br.edu.fatecgru.model.entity.PrestadorServico;
import br.edu.fatecgru.model.entity.ServicoFavorito;
import br.edu.fatecgru.service.ConsumidorService;
import br.edu.fatecgru.service.CursoFavoritoService;
import br.edu.fatecgru.service.CursoService;
import br.edu.fatecgru.service.PrestadorService;
import br.edu.fatecgru.service.ServicoFavoritoService;
import br.edu.fatecgru.service.ServicoService;
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
	
	//CADASTRO JA PRONTO - TESTA AI PRA VER SE O CABRA É BOM MESMO
	@PostMapping("/cadastro")
	public String cadastrarConsumidorServico(ConsumidorServicoCadastroDTO dto) {
	    consumidorService.salvar(dto);
		return "redirect:/consumidor/home";
	}
	
	@GetMapping("/home")
    public String home(HttpSession session, Model model) {
		List<ServicoDTO> servicos = servicoService.buscarServicosMaisBaratos();
		ConsumidorServico consu = (ConsumidorServico) session.getAttribute("usuarioLogado");
		List<ServicoDTO> servicoF = servicoFservice.listarServicosFavoritosPorUsuario(consu.getId());
	    model.addAttribute("consu", consu);
	    model.addAttribute("servicos",servicos);
	    model.addAttribute("servicoF", servicoF);
        return "homeconsumidor";
    }

	@GetMapping("/educacional")
    public String educacional(HttpSession session, Model model) {
		List<CursoDTO> curso = cursoService.buscarCursosMaisBaratos();
		ConsumidorServico consumidor = (ConsumidorServico) session.getAttribute("usuarioLogado");
		List<CursoDTO> cursoF = cursoFservice.listarCursosFavoritosPorUsuario(consumidor.getId());
	    model.addAttribute("consumidor", consumidor);
		model.addAttribute("cursos", curso);
		model.addAttribute("cursoF", cursoF);
        return "educacionalconsu";
    }
	
	@GetMapping("/catalogo")
    public String catalogo(HttpSession session, Model model) {
		List<ServicoDTO> servicos = servicoService.buscarTodosServico();
		ConsumidorServico consu = (ConsumidorServico) session.getAttribute("usuarioLogado");
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
		List<CursoDTO> curso = cursoService.listarTodosCursos();
		ConsumidorServico consumidor = (ConsumidorServico) session.getAttribute("usuarioLogado");
	    model.addAttribute("consumidor", consumidor);
		model.addAttribute("cursos", curso);
        return "cursoconsu";
    }
	
	@GetMapping("/{id}/servico")
    public String servico(HttpSession session, Model model, @PathVariable int id) {
		ServicoCadastroDTO dto = servicoService.buscarServicoPorId(id);
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
    public String perfil(Model model) {
		model
		.addAttribute("consumidor", new ConsumidorServico());
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
		cursoFservice.favoritar(consumidor.getId(), id);
	    model.addAttribute("consumidor", consumidor);
        return "redirect:/consumidor/educacional";
	}
	
	@GetMapping("/{id}/desfavoritarServico")
    public String desfavoritarServico(HttpSession session, Model model, @PathVariable int id) {
		ConsumidorServico consumidor = (ConsumidorServico) session.getAttribute("usuarioLogado");
		cursoFservice.desfavoritar(consumidor.getId(), id);
	    model.addAttribute("consumidor", consumidor);
        return "redirect:/consumidor/educacional";
	}
	
}
