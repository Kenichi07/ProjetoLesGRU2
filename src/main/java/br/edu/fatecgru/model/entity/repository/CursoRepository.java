package br.edu.fatecgru.model.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.fatecgru.model.entity.Curso;
import br.edu.fatecgru.model.entity.Servico;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
	

	//@Query("SELECT c FROM Curso c JOIN c.usuariosQueFavoritaram u WHERE u.id = :usuarioId")
	//List<Curso> findCursosFavoritosByUsuarioId(@Param("usuarioId") int usuarioId);
	
	List<Curso> findTop8By();
	
	List<Curso> findByNomeContainingIgnoreCase(String nome);

	List<Curso> findByCategoriaNome(String nomeCategoria);

	List<Curso> findTop8ByOrderByNomeAsc();

}