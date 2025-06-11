package br.edu.fatecgru.model.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.fatecgru.model.entity.Curso;
import br.edu.fatecgru.model.entity.CursoFavorito;
import br.edu.fatecgru.model.entity.CursoFavoritoPK;
import br.edu.fatecgru.model.entity.Usuario;

@Repository
public interface CursoFavoritoRepository extends JpaRepository<CursoFavorito, CursoFavoritoPK>{
	
	public List<CursoFavorito> findByIdUsuarioId(int usuarioId);
	
	public List<CursoFavorito> findByIdUsuario(Usuario usuario);
	

	public void deleteByIdCurso(Curso curso);
	
}
