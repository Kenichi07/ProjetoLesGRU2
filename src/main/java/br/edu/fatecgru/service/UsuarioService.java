package br.edu.fatecgru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.fatecgru.DTO.LoginDTO;
import br.edu.fatecgru.DTO.UsuarioCadastroDTO;
import br.edu.fatecgru.model.entity.Administrador;
import br.edu.fatecgru.model.entity.ConsumidorServico;
import br.edu.fatecgru.model.entity.CursoFavorito;
import br.edu.fatecgru.model.entity.PrestadorServico;
import br.edu.fatecgru.model.entity.Servico;
import br.edu.fatecgru.model.entity.ServicoFavorito;
import br.edu.fatecgru.model.entity.Usuario;
import br.edu.fatecgru.model.entity.repository.CursoFavoritoRepository;
import br.edu.fatecgru.model.entity.repository.ServicoFavoritoRepository;
import br.edu.fatecgru.model.entity.repository.ServicoRepository;
import br.edu.fatecgru.model.entity.repository.UsuarioRepository;

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

	@Autowired
	private ServicoRepository servicoRepository;
	
	//METODO DE AUTENTICAR
	public Usuario autenticarUsuario(LoginDTO dto) {
		Usuario usuario = usuarioRepository.findByEmail(dto.getEmail());
		if (usuario != null && usuario.getSenha().equals(dto.getSenha())) {
			return usuario; // já vai retornar o tipo real (Administrador, etc)
		}
		return null;
	}

	//METODO PARA CADASTRAR
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
	
	//LISTAR TODOS
	public List<Usuario> listAll(){
		
		return usuarioRepository.findAll();
	}
	
	//DELETAR USUARIO
	public void deletarUsuario(int id) {
	    Usuario usuario = usuarioRepository.findById(id)
	        .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
	    
	    if (usuario instanceof PrestadorServico) {
	        PrestadorServico prestador = (PrestadorServico) usuario;
	        List<Servico> servicos = prestador.getServicos();

	        if (servicos != null && !servicos.isEmpty()) {
	            for (Servico servico : servicos) {
	                List<ServicoFavorito> favoritosDoServico = servicoFavoritoRepository.findByIdServico(servico);
	                for (ServicoFavorito favorito : favoritosDoServico) {
	                    servicoFavoritoRepository.delete(favorito);
	                }

	                servicoRepository.delete(servico);
	            }
	        }
	    }
 
	    List<CursoFavorito> cursosFavoritos = cursoFavoritoRepository.findByIdUsuario(usuario);
	    for (CursoFavorito cf : cursosFavoritos) {
	        cursoFavoritoRepository.delete(cf);
	    }

	    List<ServicoFavorito> servicosFavoritos = servicoFavoritoRepository.findByIdUsuario(usuario);
	    for (ServicoFavorito sf : servicosFavoritos) {
	        servicoFavoritoRepository.delete(sf);
	    }

	    usuarioRepository.delete(usuario);
	}
	//FIM DELETAR USUARIO
	
	//METODO PARA ATUALIZAR USUARIO
	@Transactional
	public Usuario atualizarUsuario(UsuarioCadastroDTO dto) {
	    Usuario usuarioExistente = usuarioRepository.findById(dto.getId())
	        .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

	    usuarioExistente.setNome(dto.getNome());
	    usuarioExistente.setEmail(dto.getEmail());
	    usuarioExistente.setSenha(dto.getSenha());

	    if (usuarioExistente instanceof PrestadorServico) {
	        PrestadorServico prestador = (PrestadorServico) usuarioExistente;
	        prestador.setWhatsApp(dto.getWhatsApp());
	        prestadorService.salvar(prestador); 
	    } else if (usuarioExistente instanceof ConsumidorServico) {
	        ConsumidorServico consumidor = (ConsumidorServico) usuarioExistente;
	        consumidorService.salvar(consumidor); 
	    } else if (usuarioExistente instanceof Administrador) {
	        Administrador administrador = (Administrador) usuarioExistente;
	        administradorService.salvar(administrador); 
	    } else {
	        throw new RuntimeException("Tipo de usuário não suportado");
	    }

	    return usuarioExistente;
	}
}
