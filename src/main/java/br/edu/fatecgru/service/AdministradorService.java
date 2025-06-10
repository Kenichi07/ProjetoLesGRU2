package br.edu.fatecgru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecgru.DTO.AdministradorCadastroDTO;
import br.edu.fatecgru.DTO.CursoCadastroDTO;
import br.edu.fatecgru.DTO.UsuarioCadastroDTO;
import br.edu.fatecgru.DTO.UsuarioDTO;
import br.edu.fatecgru.model.entity.Usuario;
import br.edu.fatecgru.model.entity.repository.AdministradorRepository;
import br.edu.fatecgru.model.entity.repository.UsuarioRepository;

@Service
public class AdministradorService {

	@Autowired
	private AdministradorRepository administradorRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;
	

    @Autowired
    private CursoService cursoService;
    
	
    @Autowired
    private UsuarioService usuarioService;
    
    
    
    public void salvar(AdministradorCadastroDTO dto) {
        administradorRepository.save(dto.toEntity());
    }
    
    public List<UsuarioDTO> listarTodosUsuarios(){
		return usuarioRepository.findAll().stream().map(u -> new UsuarioDTO(u)).toList();
	}
    
    public void cadastrarCurso(CursoCadastroDTO dto) {
    	cursoService.salvarCurso(dto);
    }
    
    public Usuario buscarUsuarioPorId(int id) {
        Usuario usuario = usuarioRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com o ID: " + id));
        
        return usuario;
    }
    
}
