package br.edu.fatecgru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecgru.DTO.ServicoDTO;
import br.edu.fatecgru.model.entity.Cidade;
import br.edu.fatecgru.model.entity.Servico;
import br.edu.fatecgru.model.entity.ServicoCidade;
import br.edu.fatecgru.model.entity.repository.ServicoCidadeRepository;
import br.edu.fatecgru.model.entity.repository.ServicoRepository;

@Service
public class ServicoService {
	@Autowired
    private ServicoRepository servicoRepository;
    
	@Autowired
	private ServicoCidadeRepository servicoCidadeRepository;
	
	//METODOS PARA CADASTRO DE SERVICO. RESPONSAVEL: PrestadorService
	public void salvarServico(Servico s) {servicoRepository.save(s);}
	
	public void salvarServicoCidade(ServicoCidade servicoCidade) {
	    servicoCidadeRepository.save(servicoCidade);
	}
	public List<Cidade> buscarCidadesPorServicoId(int servicoId) {
	    return servicoCidadeRepository.findByIdServicoId(servicoId).stream()
	        .map(servicoCidade -> servicoCidade.getId().getCidade())
	        .toList();
	}
	///FIM DOS METODOS DE CADASTRO/// OBS:NÃO USAR DE FORMA INDEPENDENTE, PODE GERAR INCONSISTENCIA NO BANCO DE DADOS 
	
	//METODO PARA BUSCAR TODOS SERVICOS
	public List<ServicoDTO> buscarTodosServico(){
		return servicoRepository.findAll().stream()
		        .map(s -> {
		        	return new ServicoDTO(s, buscarCidadesPorServicoId(s.getId()));
		        }).toList();
	}
	
	//METODO AUX PARA BUSCAR TODOS SERVICOS CRIADOS PELO USUARIO
	public List<Servico> buscarPorPrestadorId(int idPrestador){
		return servicoRepository.findByPrestadorservicoId(idPrestador);			
	}
	
	//METODO PARA LISTAR POR ID CIDADE
    public List<ServicoDTO> buscarServicoPorCidade(int idCidade) {
        return servicoRepository.findServicoByIdCidade(idCidade)
        		.stream().map(s -> {
		        	return new ServicoDTO(s, buscarCidadesPorServicoId(s.getId()));
		        }).toList();
    }
    
    //METODO PARA LISTAR POR ID ESTADO
    public List<ServicoDTO> buscarServicoPorEstado(int idEstado) {
        return servicoRepository.findServicoByIdEstado(idEstado)
        		.stream().map(s -> {
		        	return new ServicoDTO(s, buscarCidadesPorServicoId(s.getId()));
		        }).toList();
    }
	
//	public List<ServicoDTO> buscarServicosFavoritosPorUsuario(int usuarioId) {
//        return servicoRepository.findServicosFavoritadosPorUsuario(usuarioId)
//        		.stream().map(s -> new ServicoDTO(s)).toList();
//    }
    
	
}
