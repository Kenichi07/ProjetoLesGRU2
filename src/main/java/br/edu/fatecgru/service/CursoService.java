package br.edu.fatecgru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecgru.DTO.CursoCadastroDTO;
import br.edu.fatecgru.DTO.CursoDTO;
import br.edu.fatecgru.model.entity.Curso;
import br.edu.fatecgru.model.entity.repository.CursoRepository;

@Service
public class CursoService {
	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private CategoriaService categoriaService;
	

	//Precisam ser refeitos
	/*
	public List<CursoDTO> listarTodosCursos(int usuarioId) {
        return cursoRepository.findAll().stream().map(c -> new CursoDTO(c)).toList();
    }
	
	public List<CursoDTO> buscarCursosFavoritosPorUsuario(int usuarioId) {
        return cursoRepository.findCursosFavoritosByUsuarioId(usuarioId).stream()
                     .map(c -> new CursoDTO(c)).toList();
  
	public CursoDTO buscarPorId(int idCurso){
		return cursoRepository.findById(idCurso).get().toDTO();
	}
	
	public void salvarCurso(CursoCadastroDTO dto) {
        Curso c = new Curso();
        c.setNome(dto.getNome());
        c.setDescricao(dto.getDescricao());
        c.setLinkCurso(dto.getLinkCurso());
        c.setCategoria(categoriaService.buscarCategoriaPorId(dto.getIdCategoria()));
		cursoRepository.save(c);
    }*/
}
