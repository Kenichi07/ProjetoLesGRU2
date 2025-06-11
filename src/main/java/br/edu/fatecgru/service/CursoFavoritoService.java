package br.edu.fatecgru.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.fatecgru.DTO.CursoDTO;
import br.edu.fatecgru.DTO.CursoSelectDTO;
import br.edu.fatecgru.DTO.ServicoSelectDTO;
import br.edu.fatecgru.model.entity.Curso;
import br.edu.fatecgru.model.entity.CursoFavorito;
import br.edu.fatecgru.model.entity.CursoFavoritoPK;
import br.edu.fatecgru.model.entity.Usuario;
import br.edu.fatecgru.model.entity.repository.CursoFavoritoRepository;
import br.edu.fatecgru.model.entity.repository.CursoRepository;
import br.edu.fatecgru.model.entity.repository.UsuarioRepository;

@Service
public class CursoFavoritoService {

	@Autowired
    private CursoFavoritoRepository cursoFavoritoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;
  
    //METODO PARA FAVORITAR CURSO
    @Transactional
    public void favoritar(int usuarioId, int cursoId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + usuarioId));
        
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado com ID: " + cursoId));
        
        CursoFavoritoPK pk = new CursoFavoritoPK(usuario, curso);

        if (!cursoFavoritoRepository.existsById(pk)) {
            cursoFavoritoRepository.save(new CursoFavorito(pk));
        }
    }

    // METODO PARA DESFAVORITAR CURSO
    @Transactional
    public void desfavoritar(int usuarioId, int cursoId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + usuarioId));
        
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado com ID: " + cursoId));
        
        CursoFavoritoPK pk = new CursoFavoritoPK(usuario, curso);

        if (cursoFavoritoRepository.existsById(pk)) {
            cursoFavoritoRepository.deleteById(pk);
        }
    }
    
    //METODO PARA LISTAR OS CURSOS FAVORITADOS PELO USUARIO
    public List<CursoSelectDTO> listarCursosFavoritosPorUsuario(int usuarioId) {
        List<CursoFavorito> favoritos = cursoFavoritoRepository.findByIdUsuarioId(usuarioId);

        return favoritos.stream()
                .map(f -> {
                    Curso curso = f.getId().getCurso();
                    return new CursoSelectDTO(
                        curso.getId(),
                        curso.getNome(),
                        curso.getDescricao(),
                        curso.getLinkCurso(),
                        curso.getCategoria().getNome(),
                        true // como veio da lista de favoritos, é true
                    );
                })
                .toList();
    }

    
    public List<CursoSelectDTO> buscarTodosCursos(Integer usuarioId) {
        List<Curso> todosCursos = cursoRepository.findAll();
        List<CursoFavorito> favoritosDoUsuario = cursoFavoritoRepository.findByIdUsuarioId(usuarioId);

        Set<Integer> idsFavoritados = favoritosDoUsuario.stream()
                .map(f -> f.getId().getCurso().getId())
                .collect(Collectors.toSet());

        return todosCursos.stream()
                .map(curso -> {
                    boolean favoritado = idsFavoritados.contains(curso.getId());
                    CursoSelectDTO dto = new CursoSelectDTO(curso);
                    dto.setFavoritadoPorUsuario(favoritado);
                    return dto;
                })
                .toList();
    }
}
