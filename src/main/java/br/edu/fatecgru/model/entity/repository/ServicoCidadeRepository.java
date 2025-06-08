package br.edu.fatecgru.model.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.fatecgru.model.entity.Cidade;
import br.edu.fatecgru.model.entity.Servico;
import br.edu.fatecgru.model.entity.ServicoCidade;
import br.edu.fatecgru.model.entity.ServicoCidadePK;

@Repository
public interface ServicoCidadeRepository extends JpaRepository<ServicoCidade, ServicoCidadePK>{
	
	//@Query("SELECT sc.id.cidade FROM ServicoCidade sc WHERE sc.id.servico.id = :servicoId")
    //List<Cidade> findCidadesByServicoId(@Param("servicoId") int servicoId);
	

	List<ServicoCidade> findByIdServicoId(int servicoId);
	
	@Query("SELECT sc.id.servico FROM ServicoCidade sc WHERE sc.id.cidade.estado.nome = :nome")
    List<Servico> findByNomeEstado(@Param("nome") String nome);

    @Query("SELECT sc.id.servico FROM ServicoCidade sc WHERE sc.id.cidade.nome = :nome")
    List<Servico> findByNomeCidade(@Param("nome") String nome);

    @Query("SELECT sc.id.servico FROM ServicoCidade sc WHERE sc.id.cidade.estado.id = :id")
    List<Servico> findByEstadoId(@Param("id") int id);

    @Query("SELECT sc.id.servico FROM ServicoCidade sc WHERE sc.id.cidade.id = :id")
    List<Servico> findByCidadeId(@Param("id") int id);
	

	//List<ServicoCidade> findByIdServicoId(int servicoId);


}
