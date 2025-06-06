package br.edu.fatecgru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecgru.DTO.ServicoDTO;
import br.edu.fatecgru.model.entity.Servico;
import br.edu.fatecgru.model.entity.repository.ServicoRepository;

@Service
public class ServicoService {
	@Autowired
    private ServicoRepository servicoRepository;
    	
	/*public List<ServicoDTO> bucarTodosServicos(){
		return servicoRepository.findAll().stream().map(s -> new ServicoDTO(s))
		
	}*/
	
	public void salvarServico(Servico s) {servicoRepository.save(s);}
	
	public List<ServicoDTO> listarTodosServicos(){
		return servicoRepository.findAll().stream().map(s -> new ServicoDTO(s)).toList();
	}
	
	public List<ServicoDTO> buscarPorPrestador(int idPrestador){
		return servicoRepository.findByPrestadorservicoId(idPrestador)
				.stream().map(s -> new ServicoDTO(s)).toList();		
	}
	
    public List<ServicoDTO> buscarServicosFavoritosPorUsuario(int usuarioId) {
        return servicoRepository.findServicosFavoritadosPorUsuario(usuarioId)
        		.stream().map(s -> new ServicoDTO(s)).toList();}
    
    public List<ServicoDTO> buscarServicoPorNomeCidade(String nomeCidade) {
        return servicoRepository.findByNomeCidade(nomeCidade)
        		.stream().map(s -> new ServicoDTO(s)).toList();}
    
    public List<ServicoDTO> buscarServicoPorNomeEstado(String nomeEstado) {
        return servicoRepository.findByNomeEstado(nomeEstado)
        		.stream().map(s -> new ServicoDTO(s)).toList();}

    
}
