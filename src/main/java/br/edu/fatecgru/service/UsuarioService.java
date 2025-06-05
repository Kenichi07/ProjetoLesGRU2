package br.edu.fatecgru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecgru.DTO.UsuarioDTO;
import br.edu.fatecgru.model.entity.repository.CursoRepository;
import br.edu.fatecgru.model.entity.repository.ServicoRepository;
import br.edu.fatecgru.model.entity.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private CursoRepository cursoRepository;

	@Autowired
	private ServicoRepository servicoRepository;

	
	/*public void deletarUsuario(int id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        // Remover o usuário das listas de cursos favoritos
        for (Curso curso : usuario.getCursosFavoritos()) {
            curso.getUsuariosQueFavoritaram().remove(usuario);
            cursoRepository.save(curso);
        }
        usuario.getCursosFavoritos().clear();

        // Remover o usuário das listas de serviços favoritos
        for (Servico servico : usuario.getServicosFavoritos()) {
            servico.getUsuariosQueFavoritaram().remove(usuario);
            servicoRepository.save(servico);
        }
        usuario.getServicosFavoritos().clear();

        // Persistir a remoção das associações
        usuarioRepository.save(usuario);

        // Excluir usuário
        usuarioRepository.delete(usuario);
    }*/
}
