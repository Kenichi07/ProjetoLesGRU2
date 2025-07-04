package br.edu.fatecgru.service;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.fatecgru.DTO.ServicoCadastroDTO;
import br.edu.fatecgru.DTO.ServicoDTO;
import br.edu.fatecgru.DTO.ServicoSelectDTO;
import br.edu.fatecgru.DTO.ServicoUpdateDTO;
import br.edu.fatecgru.model.entity.Categoria;
import br.edu.fatecgru.model.entity.Cidade;
import br.edu.fatecgru.model.entity.Estado;
import br.edu.fatecgru.model.entity.PrestadorServico;
import br.edu.fatecgru.model.entity.Servico;
import br.edu.fatecgru.model.entity.ServicoFavorito;
import br.edu.fatecgru.model.entity.repository.CategoriaRepository;
import br.edu.fatecgru.model.entity.repository.CidadeRepository;
import br.edu.fatecgru.model.entity.repository.EstadoRepository;
import br.edu.fatecgru.model.entity.repository.PrestadorServicoRepository;
import br.edu.fatecgru.model.entity.repository.ServicoFavoritoRepository;
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
	
	@Autowired
	private ServicoFavoritoRepository servicoFavoritoRepository;
	
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
	@Transactional
	public void atualizarServico(ServicoCadastroDTO dto) {
	    Servico servicoExistente = servicoRepository.findById(dto.getId())
	        .orElseThrow(() -> new RuntimeException("Serviço não encontrado com ID: " + dto.getId()));
	    
	    Estado estado = estadoRepository.findByNome(dto.getNomeEstado())
	            .orElseThrow(() -> new RuntimeException("Estado não encontrado: " + dto.getNomeEstado()));

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
    
	     

	    servicoExistente.setNome(dto.getNome());
	    servicoExistente.setDescricao(dto.getDescricao());
	    servicoExistente.setValor(dto.getValor());
	    servicoExistente.setCategoria(categoria);
	    servicoExistente.setCidade(cidade);

	    servicoRepository.save(servicoExistente);
	}

	@Transactional
    public void atualizarServico(ServicoUpdateDTO dto) {
        // Busca o serviço existente
        Servico servicoExistente = servicoRepository.findById(dto.getId())
            .orElseThrow(() -> new RuntimeException("Serviço não encontrado com ID: " + dto.getId()));

        // Categoria: busca por nome ou cria uma nova
        Categoria categoria = categoriaRepository.findByNome(dto.getNomeCategoria())
            .orElseGet(() -> {
                Categoria novaCategoria = new Categoria();
                novaCategoria.setNome(dto.getNomeCategoria());
                return categoriaRepository.save(novaCategoria);
            });

        // Cidade (supondo que seja única por nome apenas)
        Cidade cidade = cidadeRepository.findByNome(dto.getNomeCidade())
            .orElseThrow(() -> new RuntimeException("Cidade não encontrada: " + dto.getNomeCidade()));

        // Atualiza os campos do serviço
        servicoExistente.setNome(dto.getNome());
        servicoExistente.setDescricao(dto.getDescricao());
        servicoExistente.setValor(dto.getValor());
        servicoExistente.setCategoria(categoria);
        servicoExistente.setCidade(cidade);

        // Persiste a atualização
        servicoRepository.save(servicoExistente);
    }
	
	//METODO PARA DELETAR
	@Transactional
    public void deletarServico(int servicoId) {
        Servico servico = servicoRepository.findById(servicoId)
            .orElseThrow(() -> new RuntimeException("Serviço não encontrado com ID: " + servicoId));
        servicoFavoritoRepository.deleteByIdServico(servico);
        servicoRepository.delete(servico);
    }
	
	//METODO PARA BUSCAR TODOS SERVICOS
	public List<ServicoDTO> buscarTodosServico(){
		return servicoRepository.findAll().stream()
		        .map(s -> new ServicoDTO(s)).toList();
	}
	
	public List<ServicoDTO> buscarServicosMaisBaratos() {
	    return servicoRepository.findTop8ByOrderByPrecoAsc()
	            .stream()
	            .map(ServicoDTO::new)
	            .toList();
	}
	

	public List<ServicoSelectDTO> buscarServicosMaisBaratos2(int usuarioId) {
	    List<Servico> todosServicos = servicoRepository.findAll();
	    List<ServicoFavorito> favoritosDoUsuario = servicoFavoritoRepository.findByIdUsuarioId(usuarioId);
	
	    Set<Integer> idsFavoritados = favoritosDoUsuario.stream()
	            .map(f -> f.getId().getServico().getId())
	            .collect(Collectors.toSet());

	    List<Servico> naoFavoritados = todosServicos.stream()
	            .filter(servico -> !idsFavoritados.contains(servico.getId()))
	            .sorted(Comparator.comparing(Servico::getValor)) 
	            .limit(8).toList();

	    return naoFavoritados.stream()
	            .map(servico -> {
	                ServicoSelectDTO dto = new ServicoSelectDTO(servico);
	                dto.setFavoritadoPorUsuario(false);
	                return dto;
	            }).toList();
	}

	public List<ServicoSelectDTO> buscarServicosMaisBaratos(int usuarioId) {
	    List<Servico> servicos = servicoRepository.findTop8ByOrderByPrecoAsc();

	    List<ServicoFavorito> favoritosDoUsuario = servicoFavoritoRepository.findByIdUsuarioId(usuarioId);

        Set<Integer> idsFavoritados = favoritosDoUsuario.stream()
                .map(f -> f.getId().getServico().getId())
                .collect(Collectors.toSet()); 

        return servicos.stream()
                .map(servico -> {
                    boolean favoritado = idsFavoritados.contains(servico.getId());
                    ServicoSelectDTO dto = new ServicoSelectDTO(servico);
                    dto.setFavoritadoPorUsuario(favoritado);
                    return dto;
                }).toList();
        }
	
	
	//METODO AUX PARA BUSCAR TODOS SERVICOS CRIADOS PELO PRESTADOR
	public List<Servico> buscarPorPrestadorId(int idPrestador){
		return servicoRepository.findByPrestadorservicoId(idPrestador);			
	}
   
    //METODO BUSCAR POR ID
    public ServicoCadastroDTO buscarServicoPorId(int servicoId) {
        	Servico s = servicoRepository.findById(servicoId).get();
        	return new ServicoCadastroDTO(s);
    }

    public ServicoDTO buscarServicoDTOPorId(int servicoId) {
    	Servico s = servicoRepository.findById(servicoId).get();
    	return new ServicoDTO(s);
    }
    
    //METODO BUSCAR POR NOME
    public List<ServicoSelectDTO> buscarServicoPorNome(String nome, int usuarioId) {
        List<Servico> servicos = servicoRepository.findByNomeContainingIgnoreCase(nome);

        List<ServicoFavorito> favoritos = servicoFavoritoRepository.findByIdUsuarioId(usuarioId);
        Set<Integer> idsFavoritados = favoritos.stream()
            .map(f -> f.getId().getServico().getId())
            .collect(Collectors.toSet());

        return servicos.stream()
            .map(servico -> {
                ServicoSelectDTO dto = new ServicoSelectDTO(servico);
                dto.setFavoritadoPorUsuario(idsFavoritados.contains(servico.getId()));
                return dto;
            })
            .sorted(Comparator.comparing(ServicoSelectDTO::getNomeServico, String.CASE_INSENSITIVE_ORDER))
            .toList();
    }


    //METODO BUSCAR POR FAIXA DE PRECO
    public List<ServicoDTO> buscarPorFaixaDePreco(Float min, Float max) {
        return servicoRepository.findByPrecoBetween(min, max)
            .stream()
            .map(ServicoDTO::new)
            .toList();
    }

  //METODO BUSCAR POR NOME CATEGORIA
    public List<ServicoSelectDTO> buscarPorCategoria(int categoriaId, int usuarioId) {
    	List<Servico> servicos = servicoRepository.findByCategoriaId(categoriaId);    
 	    List<ServicoFavorito> favoritosDoUsuario = servicoFavoritoRepository.findByIdUsuarioId(usuarioId);

 	    Set<Integer> idsFavoritados = favoritosDoUsuario.stream()
 	            .map(f -> f.getId().getServico().getId())
 	            .collect(Collectors.toSet());

 	    return servicos.stream()
 	            .map(servico -> {
 	                boolean favoritado = idsFavoritados.contains(servico.getId());
 	                ServicoSelectDTO dto = new ServicoSelectDTO(servico);
 	                dto.setFavoritadoPorUsuario(favoritado);
 	                return dto;
 	            })
 	            .toList();
    }
    
    //METODO PARA LISTAR POR ID CIDADE
    public List<ServicoSelectDTO> buscarServicoPorCidade(int idCidade, int usuarioId) {
        List<Servico> servicos = servicoRepository.findServicoByIdCidade(idCidade);

        List<ServicoFavorito> favoritos = servicoFavoritoRepository.findByIdUsuarioId(usuarioId);
        Set<Integer> idsFavoritados = favoritos.stream()
            .map(f -> f.getId().getServico().getId())
            .collect(Collectors.toSet());

        return servicos.stream()
            .map(servico -> {
                ServicoSelectDTO dto = new ServicoSelectDTO(servico);
                dto.setFavoritadoPorUsuario(idsFavoritados.contains(servico.getId()));
                return dto;
            })
            .sorted(Comparator.comparing(ServicoSelectDTO::getNomeServico, String.CASE_INSENSITIVE_ORDER))
            .toList();
    }

    
    //METODO PARA LISTAR POR ID ESTADO
    public List<ServicoSelectDTO> buscarServicoPorEstado(int idEstado, int usuarioId) {
        List<Servico> servicos = servicoRepository.findServicoByIdEstado(idEstado);

        List<ServicoFavorito> favoritos = servicoFavoritoRepository.findByIdUsuarioId(usuarioId);
        Set<Integer> idsFavoritados = favoritos.stream()
            .map(f -> f.getId().getServico().getId())
            .collect(Collectors.toSet());

        return servicos.stream()
            .map(servico -> {
                ServicoSelectDTO dto = new ServicoSelectDTO(servico);
                dto.setFavoritadoPorUsuario(idsFavoritados.contains(servico.getId()));
                return dto;
            })
            .sorted(Comparator.comparing(ServicoSelectDTO::getNomeServico, String.CASE_INSENSITIVE_ORDER))
            .toList();
    }
    
    //METODO PARA LISTAR POR NOME CIDADE
    public List<ServicoSelectDTO> buscarServicoPorNomeCidade(String nomeCidade, int usuarioId) {
        List<Servico> servicos = servicoRepository.findByCidadeNomeIgnoreCase(nomeCidade);

        List<ServicoFavorito> favoritos = servicoFavoritoRepository.findByIdUsuarioId(usuarioId);
        Set<Integer> idsFavoritados = favoritos.stream()
            .map(f -> f.getId().getServico().getId())
            .collect(Collectors.toSet());

        return servicos.stream()
            .map(servico -> {
                ServicoSelectDTO dto = new ServicoSelectDTO(servico);
                dto.setFavoritadoPorUsuario(idsFavoritados.contains(servico.getId()));
                return dto;
            })
            .sorted(Comparator.comparing(ServicoSelectDTO::getNomeServico, String.CASE_INSENSITIVE_ORDER))
            .toList();
    }

    //METODO PARA LISTAR POR NOME ESTADO
    public List<ServicoSelectDTO> buscarServicoPorNomeEstado(String nomeEstado, int usuarioId) {
        List<Servico> servicos = servicoRepository.findByCidadeEstadoNomeIgnoreCase(nomeEstado);

        List<ServicoFavorito> favoritos = servicoFavoritoRepository.findByIdUsuarioId(usuarioId);
        Set<Integer> idsFavoritados = favoritos.stream()
            .map(f -> f.getId().getServico().getId())
            .collect(Collectors.toSet());

        return servicos.stream()
            .map(servico -> {
                ServicoSelectDTO dto = new ServicoSelectDTO(servico);
                dto.setFavoritadoPorUsuario(idsFavoritados.contains(servico.getId()));
                return dto;
            })
            .sorted(Comparator.comparing(ServicoSelectDTO::getNomeServico, String.CASE_INSENSITIVE_ORDER))
            .toList();
    }

    //METODO BUSCA SERVIÇOS POR TERMO NO NOME, CATEGORIA, CIDADE E ESTADO
    public List<ServicoSelectDTO> buscarPorTermo(String termo, int usuarioId) {
        List<Servico> servicos = servicoRepository.buscarPorTermoGeral(termo);
        List<ServicoFavorito> favoritos = servicoFavoritoRepository.findByIdUsuarioId(usuarioId);
        Set<Integer> idsFavoritados = favoritos.stream()
                .map(f -> f.getId().getServico().getId())
                .collect(Collectors.toSet());

        // Converter para DTO
        return servicos.stream()
                .map(servico -> {
                    boolean favoritado = idsFavoritados.contains(servico.getId());
                    ServicoSelectDTO dto = new ServicoSelectDTO(servico);
                    dto.setFavoritadoPorUsuario(favoritado);
                    return dto;
                })
                .toList();
    }

}
