package br.edu.fatecgru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatecgru.DTO.PrestadorServicoCadastroDTO;
import br.edu.fatecgru.DTO.ServicoCadastroDTO;
import br.edu.fatecgru.DTO.ServicoDTO;
import br.edu.fatecgru.model.entity.PrestadorServico;
import br.edu.fatecgru.model.entity.Servico;
import br.edu.fatecgru.service.PrestadorService;

@RestController
//@Controller
@RequestMapping("/prestador")
public class PrestadorController {

	@Autowired
	private PrestadorService prestadorService;
	
	//CADASTRO JA PRONTO - TESTA AI PRA VER SE O CABRA É BOM MESMO
	@PostMapping("/cadastro")
	public void cadastrarPrestadorServico(@RequestBody PrestadorServicoCadastroDTO dto) {
		prestadorService.cadastrarPrestadorServico(dto);
	}
	
	//CADASTRO DE SERVICO
	@PostMapping("/{idPrestador}/servicos")
    public void cadastrarServico(@PathVariable int idPrestador,@RequestBody ServicoCadastroDTO dto) { 
		prestadorService.cadastrarServico(dto, idPrestador);
    }
	
	//LISTA OS SERVIÇOS DO PRESTADOR 
	@GetMapping("/{idPrestador}/servicos")
	public List<ServicoDTO> buscarServicosDoPrestador(@PathVariable int idPrestador) {
        return prestadorService.buscarServicosCriados(idPrestador);
    }
    
	
	
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
	
	@GetMapping("/curso")
    public String curso() {
        return "cursoindividualpresta";
    }
	
	@GetMapping("/list")
    public String meusServicos() {
        return "meusServicos";
	}
	
	@GetMapping("/servico")
    public String servico() {
        return "servicoindividual";
	}
	
	@GetMapping("/new")
	public String newServico(Model model) {
		model
			.addAttribute("servico", new Servico())
			.addAttribute("novo", true);
		return "formpresta";
	}
	
	@GetMapping("/{id}/edit")
	public String editServico(Model model, @PathVariable Integer id) {
		PrestadorServico servico = prestadorService.getByCode(id);
		model
			.addAttribute("servico", servico)
			.addAttribute("novo", false);
		return "formpresta";
	}
	
	@GetMapping("/{id}/delete")
	public String delete(@PathVariable Integer id) {
		prestadorService.delete(id);
		return "redirect:/prestador/list";
	}
	
	@GetMapping("/prefil")
    public String perfil() {
        return "meuperfil";
	}
	
}
