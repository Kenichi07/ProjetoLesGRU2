package br.edu.fatecgru.model.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.fatecgru.model.entity.Administrador;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Integer>{

}
