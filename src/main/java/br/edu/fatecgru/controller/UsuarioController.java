package br.edu.fatecgru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatecgru.DTO.LoginDTO;
import br.edu.fatecgru.DTO.UsuarioCadastroDTO;
import br.edu.fatecgru.service.CursoService;
import br.edu.fatecgru.service.ServicoService;
import br.edu.fatecgru.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private CursoService cursoService;
	
	@Autowired
	private ServicoService servicoService;
	
	/*@PostMapping("/autenticar")
    public UsuarioDTO autenticarUsuario(@RequestBody LoginDTO dto) {
        boolean autenticado = usuarioService.autenticarUsuario(dto);
        return ResponseEntity.ok(autenticado);
    }*/
	
	@PostMapping("/cadastro")
	public void cadastrarUsuario(@RequestBody UsuarioCadastroDTO dto) {
	   usuarioService.cadastrarUsuario(dto);
	}
	
	
	/*
	@DeleteMapping("/{usuarioId}")
    public void deletarUsuario(@PathVariable int usuarioId) {
        usuarioService.deletarUsuario(usuarioId);
    }
    */
	
	//Precisam ser reformulados
		/*
		@GetMapping("/{usuarioId}/cursos_favoritos")
	    public List<CursoDTO> listarCursosFavoritos(@PathVariable int usuarioId) {
	        return cursoService.buscarCursosFavoritosPorUsuario(usuarioId);
	    }
		
		@GetMapping("/{usuarioId}/servicos_favoritos")
	    public List<ServicoDTO> listarServicoFavoritos(@PathVariable int usuarioId) {
	        return servicoService.buscarServicosFavoritosPorUsuario(usuarioId);
	    }*/
}
