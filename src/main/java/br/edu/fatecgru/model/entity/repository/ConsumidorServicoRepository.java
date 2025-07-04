package br.edu.fatecgru.model.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.fatecgru.model.entity.ConsumidorServico;

@Repository
public interface ConsumidorServicoRepository extends JpaRepository<ConsumidorServico, Integer>{

}
