package br.edu.fatecgru.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecgru.DTO.CursoDTO;
import br.edu.fatecgru.model.entity.repository.CursoRepository;

@Service
public class CursoService {
	@Autowired
	private CursoRepository cursoRepository;
	
	public List<CursoDTO> buscarCursosFavoritosPorUsuario(int usuarioId) {
        return cursoRepository.findCursosFavoritosByUsuarioId(usuarioId).stream()
                     .map(c -> new CursoDTO(
                         c.getId(),
                         c.getNome(),
                         c.getDescricao(),
                         c.getLinkCurso(),
                         c.getCategoria().getNome()
                     ))
                     .collect(Collectors.toList());
    }
	
}
