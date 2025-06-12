package br.edu.fatecgru.model.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.fatecgru.model.entity.Curso;
import br.edu.fatecgru.model.entity.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {
	List<Servico> findByPrestadorservicoId(int idPrestador);
	
	@Query("SELECT s FROM Servico s WHERE s.cidade.id = :idCidade")
	List<Servico> findServicoByIdCidade(@Param("idCidade") int idCidade);

	@Query("SELECT s FROM Servico s WHERE s.cidade.estado.id = :idEstado")
	List<Servico> findServicoByIdEstado(@Param("idEstado") int idEstado);

	@Query("SELECT s FROM Servico s ORDER BY s.preco ASC LIMIT 8")
	List<Servico> findTop8ByOrderByPrecoAsc();
	
	@Query("SELECT s FROM Servico s ORDER BY s.preco ASC LIMIT 20")
	List<Servico> findTop20ByOrderByPrecoAsc();
	
	List<Servico> findByNomeContainingIgnoreCase(String nome);
	
	List<Servico> findByPrecoBetween(Float min, Float max);

	List<Servico> findByCategoriaNome(String nomeCategoria);
	
	List<Servico> findByCategoriaId(Integer categoriaId);
	
	List<Servico> findByCidadeNomeIgnoreCase(String nomeCidade);

	List<Servico> findByCidadeEstadoNomeIgnoreCase(String nomeEstado);

	@Query("""
		    SELECT DISTINCT s FROM Servico s
		    WHERE 
		        LOWER(s.nome) LIKE LOWER(CONCAT('%', :termo, '%')) OR
		        LOWER(s.categoria.nome) LIKE LOWER(CONCAT('%', :termo, '%')) OR
		        LOWER(s.cidade.nome) LIKE LOWER(CONCAT('%', :termo, '%')) OR
		        LOWER(s.cidade.estado.nome) LIKE LOWER(CONCAT('%', :termo, '%'))
		    """)
		List<Servico> buscarPorTermoGeral(@Param("termo") String termo);

}
