package br.edu.fatecgru.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.fatecgru.DTO.ServicoDTO;
import br.edu.fatecgru.DTO.ServicoSelectDTO;
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
    
    //METODO PARA LISTAR CURSOS FAVORITOS DO USUARIO
    public List<ServicoSelectDTO> listarServicosFavoritosPorUsuario(int usuarioId) {
        List<ServicoFavorito> favoritos = servicoFavoritoRepository.findByIdUsuarioId(usuarioId);

        return favoritos.stream()
                .map(f -> {
                    Servico servico = f.getId().getServico();
                    ServicoSelectDTO dto = new ServicoSelectDTO(servico);
                    dto.setFavoritadoPorUsuario(true);
                    return dto;
                })
                .toList();
    }

    
    
    public List<ServicoSelectDTO> buscarTodosServicos(Integer usuarioId) {
        List<Servico> todosServicos = servicoRepository.findAll();
        List<ServicoFavorito> favoritosDoUsuario = servicoFavoritoRepository.findByIdUsuarioId(usuarioId);

        Set<Integer> idsFavoritados = favoritosDoUsuario.stream()
                .map(f -> f.getId().getServico().getId())
                .collect(Collectors.toSet()); 

        return todosServicos.stream()
                .map(servico -> {
                    boolean favoritado = idsFavoritados.contains(servico.getId());
                    ServicoSelectDTO dto = new ServicoSelectDTO(servico);
                    dto.setFavoritadoPorUsuario(favoritado);
                    return dto;
                })
                .toList();}    
}
