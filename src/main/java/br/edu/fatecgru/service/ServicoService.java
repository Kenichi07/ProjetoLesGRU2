package br.edu.fatecgru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecgru.DTO.ServicoCadastroDTO;
import br.edu.fatecgru.DTO.ServicoDTO;
import br.edu.fatecgru.model.entity.Categoria;
import br.edu.fatecgru.model.entity.Cidade;
import br.edu.fatecgru.model.entity.Estado;
import br.edu.fatecgru.model.entity.PrestadorServico;
import br.edu.fatecgru.model.entity.Servico;
import br.edu.fatecgru.model.entity.repository.CategoriaRepository;
import br.edu.fatecgru.model.entity.repository.CidadeRepository;
import br.edu.fatecgru.model.entity.repository.EstadoRepository;
import br.edu.fatecgru.model.entity.repository.PrestadorServicoRepository;
import br.edu.fatecgru.model.entity.repository.ServicoRepository;

@Service
public class ServicoService {
	@Autowired
    private ServicoRepository servicoRepository;
    
	@Autowired
    private EstadoRepository estadoRepository;
	@Autowired
    private CidadeRepository cidadeRepository;
	@Autowired
    private CategoriaRepository categoriaRepository;
    
	@Autowired
	private PrestadorServicoRepository prestadorServicoRepository;
	
	//METODO PARA CADASTRO DE SERVICO. RESPONSAVEL: PrestadorService
	public void salvarServico(ServicoCadastroDTO dto) {
        
        Estado estado = estadoRepository.findByNome(dto.getNomeEstado())
                .orElseGet(() -> {
                    Estado novoEstado = new Estado(dto.getNomeEstado(), null);
                    return estadoRepository.save(novoEstado);
                });

        Cidade cidade = cidadeRepository.findByNomeAndEstado(dto.getNomeCidade(), estado)
                .orElseGet(() -> {
                    Cidade novaCidade = new Cidade(dto.getNomeCidade(), estado);
                    return cidadeRepository.save(novaCidade);
                });

      
        Categoria categoria = categoriaRepository.findByNome(dto.getNomeCategoria())
                .orElseGet(() -> {
                    Categoria novaCategoria = new Categoria();
                    novaCategoria.setNome(dto.getNomeCategoria());
                    return categoriaRepository.save(novaCategoria);
                });

        
        PrestadorServico prestador = prestadorServicoRepository.findById(dto.getPrestadorServicoId())
                .orElseThrow(() -> new RuntimeException("Prestador de serviço não encontrado"));

       
        Servico servico = new Servico(
                dto.getNome(),
                dto.getDescricao(),
                dto.getValor(),
                cidade,
                prestador,
                categoria
        );

        servicoRepository.save(servico);
    }
	
	//METODOS PARA ATUALIZAR SERVICO
	public void atualizarServico(ServicoDTO dto) {
	    Servico servicoExistente = servicoRepository.findById(dto.getId())
	        .orElseThrow(() -> new RuntimeException("Serviço não encontrado com ID: " + dto.getId()));

	    PrestadorServico prestador = prestadorServicoRepository.findByNome(dto.getNomePrestadorServico())
		        .orElseThrow(() -> new RuntimeException("Prestador de serviço não encontrado: " + dto.getNomePrestadorServico()));
	    
	    Estado estado = estadoRepository.findByNome(dto.getEstado())
	            .orElseThrow(() -> new RuntimeException("Estado não encontrado: " + dto.getEstado()));

        Cidade cidade = cidadeRepository.findByNomeAndEstado(dto.getCidade(), estado)
                .orElseGet(() -> {
                    Cidade novaCidade = new Cidade(dto.getCidade(), estado);
                    return cidadeRepository.save(novaCidade);
                });

      
        Categoria categoria = categoriaRepository.findByNome(dto.getNomeCategoria())
                .orElseGet(() -> {
                    Categoria novaCategoria = new Categoria();
                    novaCategoria.setNome(dto.getNomeCategoria());
                    return categoriaRepository.save(novaCategoria);
                });
    
	     

	    servicoExistente.setNome(dto.getNomeServico());
	    servicoExistente.setDescricao(dto.getDescricao());
	    servicoExistente.setValor(dto.getValor());
	    servicoExistente.setCategoria(categoria);
	    servicoExistente.setCidade(cidade);
	    servicoExistente.setPrestadorservico(prestador);

	    servicoRepository.save(servicoExistente);
	}

	
	//METODO PARA BUSCAR TODOS SERVICOS
	public List<ServicoDTO> buscarTodosServico(){
		return servicoRepository.findAll().stream()
		        .map(s -> new ServicoDTO(s)).toList();
	}
	
	//METODO AUX PARA BUSCAR TODOS SERVICOS CRIADOS PELO USUARIO
	public List<Servico> buscarPorPrestadorId(int idPrestador){
		return servicoRepository.findByPrestadorservicoId(idPrestador);			
	}
	
	//METODO PARA LISTAR POR ID CIDADE
    public List<ServicoDTO> buscarServicoPorCidade(int idCidade) {
        return servicoRepository.findServicoByIdCidade(idCidade)
        		.stream().map(s -> new ServicoDTO(s)).toList();
    }
    
    //METODO PARA LISTAR POR ID ESTADO
    public List<ServicoDTO> buscarServicoPorEstado(int idEstado) {
        return servicoRepository.findServicoByIdEstado(idEstado)
        		.stream().map(s -> new ServicoDTO(s)).toList();
    }
	
//	public List<ServicoDTO> buscarServicosFavoritosPorUsuario(int usuarioId) {
//        return servicoRepository.findServicosFavoritadosPorUsuario(usuarioId)
//        		.stream().map(s -> new ServicoDTO(s)).toList();
//    }
    
	
}
