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
	
	//METODOS PARA CADASTRO DE SERVICO. RESPONSAVEL: PrestadorService
	
	public void salvarServico(ServicoCadastroDTO dto) {
        // Buscar ou criar o Estado
        Estado estado = estadoRepository.findByNome(dto.getNomeEstado())
                .orElseGet(() -> {
                    Estado novoEstado = new Estado(dto.getNomeEstado(), null);
                    return estadoRepository.save(novoEstado);
                });

        // Buscar ou criar a Cidade
        Cidade cidade = cidadeRepository.findByNomeAndEstado(dto.getNomeCidade(), estado)
                .orElseGet(() -> {
                    Cidade novaCidade = new Cidade(dto.getNomeCidade(), estado);
                    return cidadeRepository.save(novaCidade);
                });

        // Buscar ou criar a Categoria
        Categoria categoria = categoriaRepository.findByNome(dto.getNomeCategoria())
                .orElseGet(() -> {
                    Categoria novaCategoria = new Categoria();
                    novaCategoria.setNome(dto.getNomeCategoria());
                    return categoriaRepository.save(novaCategoria);
                });

        // Buscar o Prestador de Serviço
        PrestadorServico prestador = prestadorServicoRepository.findById(dto.getPrestadorServicoId())
                .orElseThrow(() -> new RuntimeException("Prestador de serviço não encontrado"));

        // Criar o serviço
        Servico servico = new Servico(
                dto.getNome(),
                dto.getDescricao(),
                dto.getValor(),
                cidade,
                prestador,
                categoria
        );

        // Salvar no banco
        servicoRepository.save(servico);
    }
	
//	public void salvarServicoCidade(ServicoCidade servicoCidade) {
//	    servicoCidadeRepository.save(servicoCidade);
//	}
//	public List<Cidade> buscarCidadesPorServicoId(int servicoId) {
//	    return servicoCidadeRepository.findByIdServicoId(servicoId).stream()
//	        .map(servicoCidade -> servicoCidade.getId().getCidade())
//	        .toList();
//	}
	///FIM DOS METODOS DE CADASTRO/// OBS:NÃO USAR DE FORMA INDEPENDENTE, PODE GERAR INCONSISTENCIA NO BANCO DE DADOS 
	
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
