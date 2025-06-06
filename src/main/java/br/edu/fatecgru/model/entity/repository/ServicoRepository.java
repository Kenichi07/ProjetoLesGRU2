package br.edu.fatecgru.model.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.fatecgru.model.entity.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {
	
	@Query("SELECT s FROM Servico s JOIN s.usuariosQueFavoritaram u WHERE u.id = :usuarioId")
    List<Servico> findServicosFavoritadosPorUsuario(@Param("usuarioId") int usuarioId);
	
	@Query("SELECT s FROM Servico s JOIN s.servicoCidade c WHERE LOWER(c.nome) LIKE LOWER(CONCAT('%', :nomeCidade, '%'))")
	List<Servico> findByNomeCidade(@Param("nomeCidade") String nomeCidade);

	@Query("SELECT s FROM Servico s JOIN s.servicoCidade c JOIN c.estado e WHERE LOWER(e.nome) LIKE LOWER(CONCAT('%', :nomeEstado, '%'))")
	List<Servico> findByNomeEstado(@Param("nomeEstado") String nomeEstado);
	
	List<Servico> findByPrestadorservicoId(int idPrestador);
}
