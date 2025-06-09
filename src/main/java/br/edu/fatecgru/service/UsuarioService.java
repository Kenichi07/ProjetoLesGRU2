package br.edu.fatecgru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.fatecgru.DTO.LoginDTO;
import br.edu.fatecgru.DTO.UsuarioCadastroDTO;
import br.edu.fatecgru.model.entity.Administrador;
import br.edu.fatecgru.model.entity.ConsumidorServico;
import br.edu.fatecgru.model.entity.CursoFavorito;
import br.edu.fatecgru.model.entity.PrestadorServico;
import br.edu.fatecgru.model.entity.ServicoFavorito;
import br.edu.fatecgru.model.entity.Usuario;
import br.edu.fatecgru.model.entity.repository.CursoFavoritoRepository;
import br.edu.fatecgru.model.entity.repository.ServicoFavoritoRepository;
import br.edu.fatecgru.model.entity.repository.UsuarioRepository;
import jakarta.servlet.http.HttpSession;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Lazy
	@Autowired
	private AdministradorService administradorService;
	
	@Autowired
	private PrestadorService prestadorService;
	
	@Autowired
	private ConsumidorService consumidorService;
	
	@Autowired
	private CursoFavoritoRepository cursoFavoritoRepository;

	@Autowired
	private ServicoFavoritoRepository servicoFavoritoRepository;

	
	//METODO DE AUTENTICAR
	public Usuario autenticarUsuario(LoginDTO dto) {
		Usuario usuario = usuarioRepository.findByEmail(dto.getEmail());
		if (usuario != null && usuario.getSenha().equals(dto.getSenha())) {
			return usuario; // já vai retornar o tipo real (Administrador, etc)
		}
		return null;
	}
	/*public UsuarioDTO autenticarUsuario(LoginDTO dto) {
	    if (usuarioRepository.existsByEmailAndSenha(dto.getEmail(), dto.getSenha())) {
	        return new UsuarioDTO(usuarioRepository.findByEmail(dto.getEmail()));
	    }
	    return null;
	}*/
	//FIM DOS METODOS DE AUTENTICAR
	
	public Usuario cadastrarUsuario(UsuarioCadastroDTO dto) {
	    if (dto.getPapel().equalsIgnoreCase("ADMINISTRADOR")) {
	    	administradorService.salvar(dto.toAdministradorCadastroDTO());
	        Usuario usuario = usuarioRepository.findByEmail(dto.getEmail());
	        if (usuario != null && usuario.getSenha().equals(dto.getSenha())) {
				return usuario; // já vai retornar o tipo real (Administrador, etc)
			}
	    } else if (dto.getPapel().equalsIgnoreCase("CONSUMIDOR")) {
	    	consumidorService.salvar(dto.toConsumidorServicoCadastroDTO());
	        Usuario usuario = usuarioRepository.findByEmail(dto.getEmail());
	        if (usuario != null && usuario.getSenha().equals(dto.getSenha())) {
				return usuario; // já vai retornar o tipo real (Consumidor, etc)
			}
	    } else if (dto.getPapel().equalsIgnoreCase("PRESTADOR")) {
	    	prestadorService.salvar(dto.toPrestadorServicoCadastroDTO());
	        Usuario usuario = usuarioRepository.findByEmail(dto.getEmail());
	        if (usuario != null && usuario.getSenha().equals(dto.getSenha())) {
				return usuario; // já vai retornar o tipo real (Prestador, etc)
	        }
	    }
	    return null;
	    
	}
	
	public List<Usuario> listAll(){
		return usuarioRepository.findAll();
	}
	
	public void deletarUsuario(int id) {
	    Usuario usuario = usuarioRepository.findById(id)
	        .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

	    // Remover favoritos de cursos
	    List<CursoFavorito> cursosFavoritos = cursoFavoritoRepository.findByIdUsuario(usuario);
	    for (CursoFavorito cf : cursosFavoritos) {
	        cursoFavoritoRepository.delete(cf);
	    }

	    // Remover favoritos de serviços
	    List<ServicoFavorito> servicosFavoritos = servicoFavoritoRepository.findByIdUsuario(usuario);
	    for (ServicoFavorito sf : servicosFavoritos) {
	        servicoFavoritoRepository.delete(sf);
	    }

	    // Excluir usuário
	    usuarioRepository.delete(usuario);
	}
}
