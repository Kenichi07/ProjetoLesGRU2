package br.edu.fatecgru.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void favoritar(int usuarioId, int servicoId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + usuarioId));
        
        Servico servico = servicoRepository.findById(servicoId)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado com ID: " + servicoId));

        ServicoFavoritoPK pk = new ServicoFavoritoPK(usuario, servico);

        if (!servicoFavoritoRepository.existsById(pk)) {
            servicoFavoritoRepository.save(new ServicoFavorito(pk));
        }
    }
    
    //METODO PARA DESFAVORITAR SERVICO
    @Transactional
    public void desfavoritar(int usuarioId, int servicoId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + usuarioId));
        
        Servico servico = servicoRepository.findById(servicoId)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado com ID: " + servicoId));

        ServicoFavoritoPK pk = new ServicoFavoritoPK(usuario, servico);

        if (servicoFavoritoRepository.existsById(pk)) {
            servicoFavoritoRepository.deleteById(pk);
        }
    }
    
    //METODO PARA LISTAR CURSOS FAVORITOS DO USUARIOAdd commentMore actions
    public List<ServicoDTO> listarServicosFavoritosPorUsuario(int usuarioId) {
        List<ServicoFavorito> favoritos = servicoFavoritoRepository.findByIdUsuarioId(usuarioId);
        return favoritos.stream()
                        .map(f -> new ServicoDTO(f.getId().getServico())).toList();
    }
    
}
