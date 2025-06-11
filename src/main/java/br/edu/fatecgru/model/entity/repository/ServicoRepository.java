package br.edu.fatecgru.model.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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
	
//	//@Query("SELECT sc.id.cidade FROM ServicoCidade sc WHERE sc.id.servico.id = :servicoId")
//  //List<Cidade> findCidadesByServicoId(@Param("servicoId") int servicoId);
//	
//
//	List<ServicoCidade> findByIdServicoId(int servicoId);
//	
//	@Query("SELECT sc.id.servico FROM ServicoCidade sc WHERE sc.id.cidade.estado.nome = :nome")
//  List<Servico> findByNomeEstado(@Param("nome") String nome);
//
//  @Query("SELECT sc.id.servico FROM ServicoCidade sc WHERE sc.id.cidade.nome = :nome")
//  List<Servico> findByNomeCidade(@Param("nome") String nome);
//
//  @Query("SELECT sc.id.servico FROM ServicoCidade sc WHERE sc.id.cidade.estado.id = :id")
//  List<Servico> findByEstadoId(@Param("id") int id);
//
//  @Query("SELECT sc.id.servico FROM ServicoCidade sc WHERE sc.id.cidade.id = :id")
//  List<Servico> findByCidadeId(@Param("id") int id);
//	
//
//	//List<ServicoCidade> findByIdServicoId(int servicoId);

}
