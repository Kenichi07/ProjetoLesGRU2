package br.edu.fatecgru.service;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.fatecgru.DTO.CursoCadastroDTO;
import br.edu.fatecgru.DTO.CursoDTO;
import br.edu.fatecgru.DTO.CursoSelectDTO;
import br.edu.fatecgru.model.entity.Categoria;
import br.edu.fatecgru.model.entity.Curso;
import br.edu.fatecgru.model.entity.CursoFavorito;
import br.edu.fatecgru.model.entity.repository.CategoriaRepository;
import br.edu.fatecgru.model.entity.repository.CursoFavoritoRepository;
import br.edu.fatecgru.model.entity.repository.CursoRepository;

@Service
public class CursoService {
	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private CursoFavoritoRepository cursoFavoritoRepository;
	
	public List<CursoDTO> listarTodosCursos() {
        return cursoRepository.findAll().stream().map(c -> new CursoDTO(c)).toList();
    }
	
	public List<CursoDTO> buscarCursosMaisBaratos() {
	    return cursoRepository.findTop8By()
	            .stream()
	            .map(CursoDTO::new)
	            .toList();
	}
	
	public List<CursoSelectDTO> buscarOitoPrimeirosCursos(int usuarioId) {
	    // Buscar os 8 primeiros cursos ordenados pelo nome (A → Z)
	    List<Curso> cursos = cursoRepository.findTop8ByOrderByNomeAsc();

	    // Buscar os favoritos do usuário atual
	    List<CursoFavorito> favoritos = cursoFavoritoRepository.findByIdUsuarioId(usuarioId);

	    // Extrair os IDs dos cursos favoritados
	    Set<Integer> idsFavoritos = favoritos.stream()
	            .map(f -> f.getId().getCurso().getId())
	            .collect(Collectors.toSet());

	    // Mapear cursos para DTOs, marcando se são favoritados
	    return cursos.stream()
	            .map(curso -> {
	                CursoSelectDTO dto = new CursoSelectDTO(curso);
	                dto.setFavoritadoPorUsuario(idsFavoritos.contains(curso.getId()));
	                return dto;
	            })
	            .toList();
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
	
	//METODO PARA ATUALIZAR CURSO
	@Transactional
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

	@Transactional
	public void deletarCurso(int cursoId) {
	    Curso curso = cursoRepository.findById(cursoId)
	        .orElseThrow(() -> new RuntimeException("Curso não encontrado com ID: " + cursoId)); 
	    cursoFavoritoRepository.deleteByIdCurso(curso);
	    cursoRepository.delete(curso);
	}
	
	public List<CursoSelectDTO> buscarPorNome(String nome, int usuarioId) {
	    // Buscar cursos com nome correspondente (ignorando maiúsculas/minúsculas)
	    List<Curso> cursos = cursoRepository.findByNomeContainingIgnoreCase(nome);

	    // Buscar cursos favoritados pelo usuário
	    List<CursoFavorito> favoritosDoUsuario = cursoFavoritoRepository.findByIdUsuarioId(usuarioId);

	    // Obter os IDs dos cursos favoritados
	    Set<Integer> idsFavoritados = favoritosDoUsuario.stream()
	            .map(f -> f.getId().getCurso().getId())
	            .collect(Collectors.toSet());

	    // Montar DTOs com a flag de favorito
	    return cursos.stream()
	            .map(curso -> {
	                boolean favoritado = idsFavoritados.contains(curso.getId());
	                CursoSelectDTO dto = new CursoSelectDTO(curso);
	                dto.setFavoritadoPorUsuario(favoritado);
	                return dto;
	            })
	            .toList();
	}

	
	//METODO CONSULTA POR NOME DA CATEGORIA
	public List<CursoSelectDTO> buscarPorCategoriaId(int categoriaId, int usuarioId) {
	    // Buscar cursos pela categoria pelo ID
	    List<Curso> cursos = cursoRepository.findByCategoriaId(categoriaId);

	    // Buscar cursos favoritados pelo usuário
	    List<CursoFavorito> favoritosDoUsuario = cursoFavoritoRepository.findByIdUsuarioId(usuarioId);

	    // Obter os IDs dos cursos favoritados
	    Set<Integer> idsFavoritados = favoritosDoUsuario.stream()
	            .map(f -> f.getId().getCurso().getId())
	            .collect(Collectors.toSet());

	    // Montar DTOs com a flag de favorito
	    return cursos.stream()
	            .map(curso -> {
	                boolean favoritado = idsFavoritados.contains(curso.getId());
	                CursoSelectDTO dto = new CursoSelectDTO(curso);
	                dto.setFavoritadoPorUsuario(favoritado);
	                return dto;
	            })
	            .toList();
	}
	
	//METODO PARA BUSCAR POR NOME DO CURSO E NOME CATEGORIA
	public List<CursoSelectDTO> buscarPorNomeOuCategoria(String termo, int usuarioId) {
	    // Buscar cursos com nome ou nome da categoria contendo o termo (ignora maiúsculas/minúsculas)
	    List<Curso> cursos = cursoRepository.findByNomeContainingIgnoreCaseOrCategoriaNomeContainingIgnoreCase(termo,termo);

	    // Buscar cursos favoritados pelo usuário
	    List<CursoFavorito> favoritosDoUsuario = cursoFavoritoRepository.findByIdUsuarioId(usuarioId);

	    // Obter os IDs dos cursos favoritados
	    Set<Integer> idsFavoritados = favoritosDoUsuario.stream()
	            .map(f -> f.getId().getCurso().getId())
	            .collect(Collectors.toSet());

	    // Montar DTOs com a flag de favorito
	    return cursos.stream()
	            .map(curso -> {
	                boolean favoritado = idsFavoritados.contains(curso.getId());
	                CursoSelectDTO dto = new CursoSelectDTO(curso);
	                dto.setFavoritadoPorUsuario(favoritado);
	                return dto;
	            })
	            .toList();
	}
	
	//METODO PARA BUSCAR POR NOME DO CURSO, NOME CATEGORIA, NOME CIDADE E NOME ESTADO
	public List<CursoSelectDTO> buscarCursosPorTermo(String termo, int usuarioId) {
	    List<Curso> cursos = cursoRepository.buscarPorNomeOuCategoriaOuCidadeOuEstado(termo);

	    Set<Integer> idsFavoritados = cursoFavoritoRepository.findByIdUsuarioId(usuarioId)
	        .stream()
	        .map(f -> f.getId().getCurso().getId())
	        .collect(Collectors.toSet());

	    return cursos.stream()
	        .map(curso -> {
	            boolean favoritado = idsFavoritados.contains(curso.getId());
	            CursoSelectDTO dto = new CursoSelectDTO(curso);
	            dto.setFavoritadoPorUsuario(favoritado);
	            return dto;
	        })
	        .toList();
	}



	public List<CursoSelectDTO> buscarOitoPrimeirosCursosNaoFavoritados(int usuarioId) {
	    // Buscar todos os cursos
	    List<Curso> todosCursos = cursoRepository.findAll();

	    // Buscar os cursos favoritados pelo usuário
	    List<CursoFavorito> favoritosDoUsuario = cursoFavoritoRepository.findByIdUsuarioId(usuarioId);

	    // Obter os IDs dos cursos favoritados
	    Set<Integer> idsFavoritados = favoritosDoUsuario.stream()
	            .map(f -> f.getId().getCurso().getId())
	            .collect(Collectors.toSet());

	    // Filtrar cursos que NÃO estão favoritados e ordenar alfabeticamente
	    List<Curso> naoFavoritados = todosCursos.stream()
	            .filter(curso -> !idsFavoritados.contains(curso.getId()))
	            .sorted(Comparator.comparing(Curso::getNome)) // ordenar por nome A-Z
	            .limit(8) // pegar os 8 primeiros
	            .toList();

	    // Montar DTOs com flag "favoritado" como false
	    return naoFavoritados.stream()
	            .map(curso -> {
	                CursoSelectDTO dto = new CursoSelectDTO(curso);
	                dto.setFavoritadoPorUsuario(false); // sabemos que não são favoritados
	                return dto;
	            })
	            .toList();
	}

}
