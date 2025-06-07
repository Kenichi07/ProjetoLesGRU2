package br.edu.fatecgru.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecgru.DTO.CursoDTO;
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

    
    // Método para usuário favoritar um curso
    public void favoritar(int usuarioId, int cursoId) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(usuarioId);
        Optional<Curso> cursoOpt = cursoRepository.findById(cursoId);

        if (usuarioOpt.isPresent() && cursoOpt.isPresent()) {
            CursoFavoritoPK pk = new CursoFavoritoPK(usuarioOpt.get(), cursoOpt.get());
            if (!cursoFavoritoRepository.existsById(pk)) {
                cursoFavoritoRepository.save(new CursoFavorito(pk));
            }
        }
    }

    // Método para usuário desfavoritar um curso
    public void desfavoritar(int usuarioId, int cursoId) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(usuarioId);
        Optional<Curso> cursoOpt = cursoRepository.findById(cursoId);

        if (usuarioOpt.isPresent() && cursoOpt.isPresent()) {
            cursoFavoritoRepository.deleteById(new CursoFavoritoPK(usuarioOpt.get(), cursoOpt.get()));
        }
    }
    
    //Metodo para listar os Cursos favoritos
    public List<CursoDTO> listarCursosFavoritosDoUsuario(int usuarioId) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(usuarioId);

        if (usuarioOpt.isPresent()) {
            return cursoFavoritoRepository.findByIdUsuarioId(usuarioId).stream()
                .map(fav -> new CursoDTO(fav.getId().getCurso()))
                .toList();
        }

        return List.of();
    }
}
