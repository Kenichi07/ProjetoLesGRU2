package br.edu.fatecgru.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatecgru.DTO.CursoDTO;
import br.edu.fatecgru.DTO.CursoSelectDTO;
import br.edu.fatecgru.DTO.PrestadorServicoCadastroDTO;
import br.edu.fatecgru.DTO.ServicoCadastroDTO;
import br.edu.fatecgru.DTO.ServicoDTO;
import br.edu.fatecgru.DTO.ServicoSelectDTO;
import br.edu.fatecgru.DTO.UsuarioCadastroDTO;
import br.edu.fatecgru.model.entity.Administrador;
import br.edu.fatecgru.model.entity.ConsumidorServico;
import br.edu.fatecgru.model.entity.PrestadorServico;
import br.edu.fatecgru.model.entity.Servico;
import br.edu.fatecgru.service.CursoFavoritoService;
import br.edu.fatecgru.service.CursoService;
import br.edu.fatecgru.service.PrestadorService;
import br.edu.fatecgru.service.ServicoService;
import br.edu.fatecgru.service.UsuarioService;
import jakarta.servlet.http.HttpSession;

//@RestController
@Controller
@RequestMapping("/prestador")
public class PrestadorController {

	@Autowired
	private PrestadorService prestadorService;
	
	@Autowired 
	private CursoService cursoService;
			
	@Autowired 
	private CursoFavoritoService cursoFservice;
	
	@Autowired
	private ServicoService servicoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	//CADASTRO JA PRONTO - TESTA AI PRA VER SE O CABRA É BOM MESMO
	@PostMapping("/cadastro")
	public void cadastrarPrestadorServico(@RequestBody PrestadorServicoCadastroDTO dto) {
		//prestadorService.cadastrarPrestadorServico(dto);
	}
	
	//CADASTRO DE SERVICO
	@PostMapping("/{idPrestador}/servicos")
    public void cadastrarServico(@RequestBody ServicoCadastroDTO dto) { 
		prestadorService.cadastrarServico(dto);
    }
	
	//LISTA OS SERVIÇOS DO PRESTADOR 
	@GetMapping("/{idPrestador}/servicos")
	public String buscarServicosDoPrestador(HttpSession session, Model model, @PathVariable int idPrestador) {
		PrestadorServico prestador = (PrestadorServico) session.getAttribute("usuarioLogado");
        List<ServicoDTO> servicos = prestadorService.buscarServicosCriados(idPrestador);
        model.addAttribute("prestador", prestador);
		return "redirect:/prestador/home";
    }
    
	@GetMapping("/home")
    public String home(HttpSession session, Model model) {
		PrestadorServico prestador = (PrestadorServico) session.getAttribute("usuarioLogado");
		List<ServicoDTO> servicos = prestadorService.buscarServicosCriados(prestador.getId());
		System.out.println(prestador.getId());
	    model.addAttribute("prestador", prestador);
	    model.addAttribute("servicos", servicos);
        return "homeprestador";
    }

	@GetMapping("/educacional")
    public String educacional(HttpSession session, Model model) {
		PrestadorServico prestador = (PrestadorServico) session.getAttribute("usuarioLogado");
		List<CursoSelectDTO> curso = cursoService.buscarOitoPrimeirosCursosNaoFavoritados(prestador.getId());
		List<CursoSelectDTO> cursoF = cursoFservice.listarCursosFavoritosPorUsuario(prestador.getId());
	    model.addAttribute("prestador", prestador);
		model.addAttribute("cursos", curso);
		model.addAttribute("cursoF", cursoF);
        return "educacionalpresta";
    }
	
	@GetMapping("/equipe")
    public String equipe(HttpSession session, Model model) {
		PrestadorServico prestador = (PrestadorServico) session.getAttribute("usuarioLogado");
		model.addAttribute("prestador", prestador);
        return "equipepresta";
	}
	
	@GetMapping("/cursos")
    public String cursos(HttpSession session, Model model) {
		PrestadorServico prestador = (PrestadorServico) session.getAttribute("usuarioLogado");
		List<CursoSelectDTO> curso = cursoFservice.buscarTodosCursos(prestador.getId());
		model.addAttribute("prestador", prestador);
		model.addAttribute("cursos", curso);
        return "cursopresta";
    }
	
	@GetMapping("/{id}/curso")
    public String curso(HttpSession session, Model model, @PathVariable int id) {
		PrestadorServico prestador = (PrestadorServico) session.getAttribute("usuarioLogado");
	    model.addAttribute("prestador", prestador);
	    model.addAttribute("curso", cursoService.buscarPorId(id));
        return "cursoindividualpresta";
    }
	
	@GetMapping("/list")
    public String meusServicos(HttpSession session, Model model) {
		PrestadorServico prestador = (PrestadorServico) session.getAttribute("usuarioLogado");
		System.out.println(prestador.getId());
		List<ServicoDTO> servicos = prestadorService.buscarServicosCriados(prestador.getId());
	    model.addAttribute("prestador", prestador);
	    model.addAttribute("servicos", servicos);
        return "meusServicos";
	}
	
	@GetMapping("/servico")
    public String servico() {
        return "servicoindividual";
	}
	
	@GetMapping("/new")
	public String newServico(HttpSession session, Model model) {
		PrestadorServico prestador = (PrestadorServico) session.getAttribute("usuarioLogado");
		model
			.addAttribute("servicoCadastroDTO", new ServicoCadastroDTO())
			.addAttribute("prestador", prestador)
			.addAttribute("novo", true);
		return "formpresta";
	}
	
	@GetMapping("/{id}/edit")
	public String editServico(HttpSession session, Model model, @PathVariable Integer id) {
		PrestadorServico prestador = (PrestadorServico) session.getAttribute("usuarioLogado");
		ServicoCadastroDTO dto = servicoService.buscarServicoPorId(id);
		System.out.println("Prestador logado: " + prestador);
		model
			.addAttribute("servicoCadastroDTO", dto)
			.addAttribute("prestador", prestador)
			.addAttribute("novo", false);
		return "formpresta";
	}
	
	@GetMapping("/{id}/delete")
	public String delete(HttpSession session, Model model, @PathVariable Integer id) {
		PrestadorServico prestador = (PrestadorServico) session.getAttribute("usuarioLogado");
		model
			.addAttribute("prestador", prestador);
		servicoService.deletarServico(id);
		return "redirect:/prestador/list";
	}
	
	@PostMapping("save")
	public String salvar(@ModelAttribute ServicoCadastroDTO dto, HttpSession session, Model model) {
		PrestadorServico prestador = (PrestadorServico) session.getAttribute("usuarioLogado");
		model.addAttribute("prestador", prestador);
	    // Forçando o id do prestador no dto para não confiar no hidden field
		dto.setPrestadorServicoId(prestador.getId());
		if (dto.getId() == null) {
	        // Cadastro novo
	        servicoService.salvarServico(dto);
	    } else {
	        // Atualização
	    	servicoService.atualizarServico(dto);
	    }
	    
		return "redirect:/prestador/list";
	}
	
	@PostMapping("savePrestador")
	public String atualizar(@ModelAttribute PrestadorServico dto, HttpSession session, Model model) {
		prestadorService.salvar(dto);
		PrestadorServico prestador = (PrestadorServico) session.getAttribute("usuarioLogado");
	    model.addAttribute("prestador", prestador);
	    return "redirect:/prestador/home";
	}
	
	@GetMapping("/perfil")
    public String perfil(HttpSession session, Model model) {
		PrestadorServico prestador = (PrestadorServico) session.getAttribute("usuarioLogado");
		model.addAttribute("prestador", prestador);
        return "perfilpresta";
	}
	
	@GetMapping("/sair")
	public String sair() {
		return "index";
	}
	
	@GetMapping("/buscar")
	public String buscarPorNome(@RequestParam("nome") String nome, HttpSession session, Model model) {
		PrestadorServico prestador = (PrestadorServico) session.getAttribute("usuarioLogado");
		List<CursoSelectDTO> cursos = cursoService.buscarPorNomeOuCategoria(nome, prestador.getId());
		model.addAttribute("prestador", prestador);
		model.addAttribute("cursos", cursos);
		return "cursopresta";
	}
	
	
	@GetMapping("/{id}/favoritar")
    public String favoritar(HttpSession session, Model model, @PathVariable int id) {
		PrestadorServico prestador = (PrestadorServico) session.getAttribute("usuarioLogado");
		cursoFservice.favoritar(prestador.getId(), id);
	    model.addAttribute("prestador", prestador);
        return "redirect:/prestador/educacional";
	}
	
	@GetMapping("/{id}/desfavoritar")
    public String desfavoritar(HttpSession session, Model model, @PathVariable int id) {
		PrestadorServico prestador = (PrestadorServico) session.getAttribute("usuarioLogado");
		cursoFservice.desfavoritar(prestador.getId(), id);
	    model.addAttribute("prestador", prestador);
        return "redirect:/prestador/educacional";
	}
	
	@GetMapping("/{id}/alterar")
    public String alterar(HttpSession session, Model model, @PathVariable int id) {
		PrestadorServico prestador = (PrestadorServico) session.getAttribute("usuarioLogado");
		List<CursoSelectDTO> dto = cursoFservice.buscarTodosCursos(prestador.getId());
		
		// Encontrar o curso selecionado na lista
	    Optional<CursoSelectDTO> cursoSelecionado = dto.stream()
	            .filter(c -> c.getId() == id)
	            .findFirst();
		
	 // Verificar se está favoritado ou não
	    if (cursoSelecionado.isPresent()) {
	        CursoSelectDTO curso = cursoSelecionado.get();
	        if (curso.isFavoritadoPorUsuario()) {
	            // Já está favoritado -> vamos desfavoritar
	            cursoFservice.desfavoritar(prestador.getId(), id);
	        } else {
	            // Ainda não está favoritado -> vamos favoritar
	            cursoFservice.favoritar(prestador.getId(), id);
	        }
	    }
		
	    model.addAttribute("prestador", prestador);
        return "redirect:/prestador/cursos";
	}

}
