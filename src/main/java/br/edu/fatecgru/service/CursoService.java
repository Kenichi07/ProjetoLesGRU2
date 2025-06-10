package br.edu.fatecgru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecgru.DTO.CursoCadastroDTO;
import br.edu.fatecgru.DTO.CursoDTO;
import br.edu.fatecgru.model.entity.Categoria;
import br.edu.fatecgru.model.entity.Curso;
import br.edu.fatecgru.model.entity.repository.CategoriaRepository;
import br.edu.fatecgru.model.entity.repository.CursoRepository;

@Service
public class CursoService {
	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
		
	
	public List<CursoDTO> listarTodosCursos() {
        return cursoRepository.findAll().stream().map(c -> new CursoDTO(c)).toList();
    }
	
	//METODO PARA CADASTRO
	public void salvarCurso(CursoCadastroDTO dto) {
	    
		Categoria categoria = categoriaRepository.findByNome(dto.getNomeCategoria())
                .orElseGet(() -> {
                    Categoria novaCategoria = new Categoria();
                    novaCategoria.setNome(dto.getNomeCategoria());
                    return categoriaRepository.save(novaCategoria);
                });

	    Curso curso = new Curso(
	        dto.getNome(),
	        dto.getDescricao(),
	        dto.getLinkCurso(),
	        categoria
	    );

	    cursoRepository.save(curso);
	}
	
	//METODO PARA UPDATE CURSO
	public void atualizarCurso(CursoDTO dto) {
	   Curso cursoExistente = cursoRepository.findById(dto.getId())
	        .orElseThrow(() -> new RuntimeException("Curso não encontrado com ID: " + dto.getId()));

	  Categoria categoria = categoriaRepository.findByNome(dto.getNomeCategoria())
	        .orElseGet(() -> {
	            Categoria novaCategoria = new Categoria();
	            novaCategoria.setNome(dto.getNomeCategoria());
	            return categoriaRepository.save(novaCategoria);
	        });

	    cursoExistente.setNome(dto.getNome());
	    cursoExistente.setDescricao(dto.getDescricao());
	    cursoExistente.setLinkCurso(dto.getLinkCurso());
	    cursoExistente.setCategoria(categoria);

	    cursoRepository.save(cursoExistente);
	}

	public CursoDTO buscarPorId(int idCurso){
		return cursoRepository.findById(idCurso).get().toDTO();
	}
	
	//Precisam ser refeitos
	/*
	
	
	public List<CursoDTO> buscarCursosFavoritosPorUsuario(int usuarioId) {
        return cursoRepository.findCursosFavoritosByUsuarioId(usuarioId).stream()
                     .map(c -> new CursoDTO(c)).toList();
  
	
	
*/
}
