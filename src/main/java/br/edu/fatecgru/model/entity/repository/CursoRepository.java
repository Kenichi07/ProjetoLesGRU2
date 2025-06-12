package br.edu.fatecgru.model.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.fatecgru.model.entity.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
	

	//@Query("SELECT c FROM Curso c JOIN c.usuariosQueFavoritaram u WHERE u.id = :usuarioId")
	//List<Curso> findCursosFavoritosByUsuarioId(@Param("usuarioId") int usuarioId);
	
	List<Curso> findTop8By();
	
	List<Curso> findByNomeContainingIgnoreCase(String nome);

	List<Curso> findByCategoriaNome(String nomeCategoria);

	List<Curso> findTop8ByOrderByNomeAsc();

	List<Curso> findByCategoriaId(Integer categoriaId);

	List<Curso> findByNomeContainingIgnoreCaseOrCategoriaNomeContainingIgnoreCase(String nome, String nomeCategoria);

	@Query("SELECT DISTINCT c FROM Curso c " +
		       "JOIN c.categoria cat " +
		       "JOIN c.cidade cid " +
		       "JOIN cid.estado est " +
		       "WHERE LOWER(c.nome) LIKE LOWER(CONCAT('%', :termo, '%')) " +
		       "OR LOWER(cat.nome) LIKE LOWER(CONCAT('%', :termo, '%')) " +
		       "OR LOWER(cid.nome) LIKE LOWER(CONCAT('%', :termo, '%')) " +
		       "OR LOWER(est.nome) LIKE LOWER(CONCAT('%', :termo, '%'))")
	List<Curso> buscarPorNomeOuCategoriaOuCidadeOuEstado(@Param("termo") String termo);

}