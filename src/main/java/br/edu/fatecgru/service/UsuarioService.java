package br.edu.fatecgru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;

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
	        Administrador admin = new Administrador();
	        admin.setNome(dto.getNome());
	        admin.setEmail(dto.getEmail());
	        admin.setSenha(dto.getSenha());
	        usuarioRepository.save(admin);
	        Usuario usuario = usuarioRepository.findByEmail(dto.getEmail());
	        if (usuario != null && usuario.getSenha().equals(dto.getSenha())) {
				return usuario; // já vai retornar o tipo real (Administrador, etc)
			}
	    } else if (dto.getPapel().equalsIgnoreCase("CONSUMIDOR")) {
	        ConsumidorServico consumidor = new ConsumidorServico();
	        consumidor.setNome(dto.getNome());
	        consumidor.setEmail(dto.getEmail());
	        consumidor.setSenha(dto.getSenha());
	        usuarioRepository.save(consumidor);
	        Usuario usuario = usuarioRepository.findByEmail(dto.getEmail());
	        if (usuario != null && usuario.getSenha().equals(dto.getSenha())) {
				return usuario; // já vai retornar o tipo real (Administrador, etc)
			}
	    } else if (dto.getPapel().equalsIgnoreCase("PRESTADOR")) {
	        PrestadorServico prestador = new PrestadorServico();
	        prestador.setNome(dto.getNome());
	        prestador.setEmail(dto.getEmail());
	        prestador.setSenha(dto.getSenha());
	        prestador.setWhatsApp(dto.getWhatsApp());
	        usuarioRepository.save(prestador);
	        Usuario usuario = usuarioRepository.findByEmail(dto.getEmail());
	        if (usuario != null && usuario.getSenha().equals(dto.getSenha())) {
				return usuario; // já vai retornar o tipo real (Administrador, etc)
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
