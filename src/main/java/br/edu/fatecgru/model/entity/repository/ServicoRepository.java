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
	
	@Query("SELECT sc.id.servico FROM ServicoCidade sc WHERE sc.id.cidade.id = :idCidade")
    List<Servico> findServicoByIdCidade(@Param("idCidade") int idCidade);

    @Query("SELECT sc.id.servico FROM ServicoCidade sc WHERE sc.id.cidade.estado.id = :idEstado")
    List<Servico> findServicoByIdEstado(@Param("idEstado") int idEstado);

   

}
