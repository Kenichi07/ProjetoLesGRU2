package br.edu.fatecgru.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecgru.DTO.CidadeDTO;
import br.edu.fatecgru.DTO.ServicoDTO;
import br.edu.fatecgru.model.entity.repository.ServicoRepository;

@Service
public class ServicoService {
	@Autowired
    private ServicoRepository servicoRepository;
    
    public List<ServicoDTO> buscarServicosFavoritosPorUsuario(int usuarioId) {
        return servicoRepository.findServicosFavoritadosPorUsuario(usuarioId).stream()
        		.map(s -> new ServicoDTO(
        				s.getId(),
        				s.getNome(),
        				s.getDescricao(),
        				s.getValor(),
        				s.getCategoria().getNome(),
        				s.getServicoCidade().stream()
                        	.map(c -> new CidadeDTO(
                                c.getNome(),
                                c.getEstado().getNome(),
                                c.getEstado().getSigla()
                        	))
                        	.collect(Collectors.toList())
        				))
        				.collect(Collectors.toList());
    }
    
    public List<ServicoDTO> buscarServicoPorNomeCidade(String nomeCidade) {
        return servicoRepository.findByNomeCidade(nomeCidade).stream()
            .map(s -> new ServicoDTO(
    				s.getId(),
    				s.getNome(),
    				s.getDescricao(),
    				s.getValor(),
    				s.getCategoria().getNome(),
    				s.getServicoCidade().stream()
                    	.map(c -> new CidadeDTO(
                            c.getNome(),
                            c.getEstado().getNome(),
                            c.getEstado().getSigla()
                    	))
                    	.collect(Collectors.toList())
    				))
    				.collect(Collectors.toList());
    }
    
    public List<ServicoDTO> buscarServicoPorNomeEstado(String nomeEstado) {
        return servicoRepository.findByNomeEstado(nomeEstado).stream()
            .map(s -> new ServicoDTO(
    				s.getId(),
    				s.getNome(),
    				s.getDescricao(),
    				s.getValor(),
    				s.getCategoria().getNome(),
    				s.getServicoCidade().stream()
                    	.map(c -> new CidadeDTO(
                            c.getNome(),
                            c.getEstado().getNome(),
                            c.getEstado().getSigla()
                    	))
                    	.collect(Collectors.toList())
    				))
    				.collect(Collectors.toList());
    }

    
}
