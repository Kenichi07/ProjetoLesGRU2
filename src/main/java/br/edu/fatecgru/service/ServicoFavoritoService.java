package br.edu.fatecgru.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecgru.DTO.ServicoDTO;
import br.edu.fatecgru.model.entity.Servico;
import br.edu.fatecgru.model.entity.ServicoFavorito;
import br.edu.fatecgru.model.entity.ServicoFavoritoPK;
import br.edu.fatecgru.model.entity.Usuario;
import br.edu.fatecgru.model.entity.repository.ServicoFavoritoRepository;
import br.edu.fatecgru.model.entity.repository.ServicoRepository;
import br.edu.fatecgru.model.entity.repository.UsuarioRepository;

@Service
public class ServicoFavoritoService {

	@Autowired
	private ServicoFavoritoRepository servicoFavoritoRepository;
	
	@Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    //METODO PARA FAVORITAR SERVICO
    public void favoritar(int usuarioId, int servicoId) {	
    	
    	Optional<Usuario> usuarioOpt = usuarioRepository.findById(usuarioId);
        Optional<Servico> servicoOpt = servicoRepository.findById(servicoId);

        if (usuarioOpt.isPresent() && servicoOpt.isPresent()) {
            ServicoFavoritoPK pk = new ServicoFavoritoPK(usuarioOpt.get(), servicoOpt.get());
            if (!servicoFavoritoRepository.existsById(pk)) {
            	servicoFavoritoRepository.save(new ServicoFavorito(pk));
            }
        }
    }
    
    //METODO PARA DESFAVORITAR SERVICO
    public void desfavoritar(int usuarioId, int servicoId) {   	
    	Optional<Usuario> usuarioOpt = usuarioRepository.findById(usuarioId);
        Optional<Servico> servicoOpt = servicoRepository.findById(servicoId);

        if (usuarioOpt.isPresent() && servicoOpt.isPresent()) {
           servicoFavoritoRepository.deleteById(new ServicoFavoritoPK(usuarioOpt.get(), servicoOpt.get()));
        }
    }
    
    //METODO PARA LISTAR CURSOS FAVORITOS DO USUARIO
    public List<ServicoDTO> listarServicosFavoritosPorUsuario(int usuarioId) {
        List<ServicoFavorito> favoritos = servicoFavoritoRepository.findByIdUsuarioId(usuarioId);
        return favoritos.stream()
                        .map(f -> new ServicoDTO(f.getId().getServico())).toList();
    }
}
