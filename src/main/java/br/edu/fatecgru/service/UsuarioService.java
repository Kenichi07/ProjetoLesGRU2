package br.edu.fatecgru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecgru.DTO.LoginDTO;
import br.edu.fatecgru.model.entity.CursoFavorito;
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
	private CursoFavoritoRepository cursoFavoritoRepository;

	@Autowired
	private ServicoFavoritoRepository servicoFavoritoRepository;

	
	//Metodo que confirma se existe o email e senha na tabela Usuario
	public boolean autenticarUsuario(LoginDTO dto) {
        return usuarioRepository.existsByEmailAndSenha(dto.getEmail(), dto.getSenha());
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
