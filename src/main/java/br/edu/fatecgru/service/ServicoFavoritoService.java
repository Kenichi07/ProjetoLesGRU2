package br.edu.fatecgru.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecgru.DTO.ServicoDTO;
import br.edu.fatecgru.model.entity.Cidade;
import br.edu.fatecgru.model.entity.Servico;
import br.edu.fatecgru.model.entity.ServicoFavorito;
import br.edu.fatecgru.model.entity.ServicoFavoritoPK;
import br.edu.fatecgru.model.entity.Usuario;
import br.edu.fatecgru.model.entity.repository.ServicoCidadeRepository;
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

    @Autowired
    private ServicoCidadeRepository servicoCidadeRepository;
    //Metodo para Usuario favoritar serviço
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
    
    //Metodo para Usuario desfavoritar serviço
    public void desfavoritar(int usuarioId, int servicoId) {   	
    	Optional<Usuario> usuarioOpt = usuarioRepository.findById(usuarioId);
        Optional<Servico> servicoOpt = servicoRepository.findById(servicoId);

        if (usuarioOpt.isPresent() && servicoOpt.isPresent()) {
           servicoFavoritoRepository.deleteById(new ServicoFavoritoPK(usuarioOpt.get(), servicoOpt.get()));
        }
    }

    /*
    //Metodos para o usuario listar seus serviços favoritos
    public List<ServicoDTO> listarFavoritosDoUsuario(int usuarioId) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(usuarioId);

        if (usuarioOpt.isEmpty()) {
            return List.of();
        }

        return servicoFavoritoRepository.findByIdUsuarioId(usuarioId).stream()
                .map(favorito -> {
                    Servico servico = favorito.getId().getServico();
                    List<Cidade> cidades = servicoCidadeRepository.findCidadesByServicoId(servico.getId());
                    return new ServicoDTO(servico, cidades);
                })
                .toList();
    }
    */
}
