package br.edu.fatecgru.model.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.fatecgru.model.entity.Consumidor;

@Repository
public interface ConsumidorRepository extends JpaRepository<Consumidor, Integer>{

}
