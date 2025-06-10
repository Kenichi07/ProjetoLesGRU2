package br.edu.fatecgru.model.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.fatecgru.model.entity.Servico;
import br.edu.fatecgru.model.entity.ServicoFavorito;
import br.edu.fatecgru.model.entity.ServicoFavoritoPK;
import br.edu.fatecgru.model.entity.Usuario;

@Repository
public interface ServicoFavoritoRepository extends JpaRepository <ServicoFavorito, ServicoFavoritoPK>{

	public List<ServicoFavorito> findByIdUsuarioId(int usuarioId);
	
	public List<ServicoFavorito> findByIdUsuario(Usuario usuario);
	
	public List<ServicoFavorito> findByIdServico(Servico servico);
}
