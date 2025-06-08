package br.edu.fatecgru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecgru.DTO.CursoCadastroDTO;
import br.edu.fatecgru.DTO.CursoDTO;
import br.edu.fatecgru.model.entity.Categoria;
import br.edu.fatecgru.model.entity.Curso;
import br.edu.fatecgru.model.entity.repository.CursoRepository;

@Service
public class CursoService {
	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private CategoriaService categoriaService;
		
	
	public List<CursoDTO> listarTodosCursos() {
        return cursoRepository.findAll().stream().map(c -> new CursoDTO(c)).toList();
    }
	
	//METODO PARA CADASTRO
	public void salvarCurso(CursoCadastroDTO dto) {
		cursoRepository.save(new Curso(
				dto.getNome(),
				dto.getDescricao(),
                dto.getLinkCurso(),
                categoriaService.buscarCategoriaPorId(dto.getIdCategoria())
                ));
    }
	
	//METODOS PARA UPDATE
	public void salvarCurso(CursoDTO dto) {
		cursoRepository.save(new Curso(
				dto.getNome(),
				dto.getDescricao(),
                dto.getLinkCurso(),
                categoriaService.buscarPorNome(dto.getNomeCategoria())
                ));
    }

	//Precisam ser refeitos
	/*
	
	
	public List<CursoDTO> buscarCursosFavoritosPorUsuario(int usuarioId) {
        return cursoRepository.findCursosFavoritosByUsuarioId(usuarioId).stream()
                     .map(c -> new CursoDTO(c)).toList();
  
	public CursoDTO buscarPorId(int idCurso){
		return cursoRepository.findById(idCurso).get().toDTO();
	}
	
*/
}
