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
  
    //METODO PARA FAVORITAR CURSO
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

    // METODO PARA DESFAVORITAR CURSO
    public void desfavoritar(int usuarioId, int cursoId) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(usuarioId);
        Optional<Curso> cursoOpt = cursoRepository.findById(cursoId);

        if (usuarioOpt.isPresent() && cursoOpt.isPresent()) {
            cursoFavoritoRepository.deleteById(new CursoFavoritoPK(usuarioOpt.get(), cursoOpt.get()));
        }
    }
    
    public List<CursoDTO> listarCursosFavoritosPorUsuario(int usuarioId) {
        List<CursoFavorito> favoritos = cursoFavoritoRepository.findByIdUsuarioId(usuarioId);
        return favoritos.stream()
                        .map(f -> new CursoDTO(f.getId().getCurso())).toList();
    }

}
