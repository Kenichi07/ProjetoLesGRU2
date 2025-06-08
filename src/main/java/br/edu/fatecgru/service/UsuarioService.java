package br.edu.fatecgru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecgru.DTO.LoginDTO;
import br.edu.fatecgru.DTO.UsuarioCadastroDTO;
import br.edu.fatecgru.DTO.UsuarioDTO;
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
	
	public void cadastrarUsuario(UsuarioCadastroDTO dto) {
	    String papel = dto.getPapel();

	    if ("PRESTADOR".equals(papel)) {
	        prestadorService.cadastrarPrestadorServico(dto.toPrestadorServicoCadastroDTO());
	    } else if ("CONSUMIDOR".equals(papel)) {
	        consumidorService.salvar(dto.toConsumidorServicoCadastroDTO());
	    } else {
	        throw new IllegalArgumentException("Papel inválido ou não informado: " + papel + dto.getNome() + dto.getEmail() + dto.getWhatsApp() + dto.getSenha());
	    }
	}


	
	public List<Usuario> listAll(){
		return usuarioRepository.findAll();
	}
	
	/*
	public void deletarUsuario(int id) {
	    Usuario usuario = usuarioRepository.findById(id).get();	   
	    for (CursoFavorito cf : cursoFavoritoRepository.findByIdUsuario(usuario)) {
	        cursoFavoritoRepository.delete(cf);
	    }
	    for (ServicoFavorito sf : servicoFavoritoRepository.findByIdUsuario(usuario)) {
	        servicoFavoritoRepository.delete(sf);
	    }
	    usuarioRepository.delete(usuario);
	}
*/
	
}
