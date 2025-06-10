package br.edu.fatecgru.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecgru.DTO.PrestadorServicoCadastroDTO;
import br.edu.fatecgru.DTO.ServicoCadastroDTO;
import br.edu.fatecgru.DTO.ServicoDTO;
import br.edu.fatecgru.model.entity.PrestadorServico;
import br.edu.fatecgru.model.entity.Servico;
import br.edu.fatecgru.model.entity.repository.PrestadorServicoRepository;

@Service
public class PrestadorService {

	@Autowired
	private PrestadorServicoRepository prestadorRepository;
	
	@Autowired
    private ServicoService servicoService;
	
	@Autowired
    private CategoriaService categoriaService;
		
	@Autowired
    private CidadeService cidadeService;
	
	//METODO DE CADASTRO DE SERVIÇO
	public void cadastrarServico(ServicoCadastroDTO dto) {
		servicoService.salvarServico(dto);
	}

	//METODO PARA LISTAR SERVICO CRIADOS PELO PRESTADOR
	public List<ServicoDTO> buscarServicosCriados(int idPrestador) {
	    Optional<PrestadorServico> prestadorOpt = prestadorRepository.findById(idPrestador);
	    if (prestadorOpt.isEmpty()) {
	        throw new RuntimeException("Prestador não encontrado.");
	    }

	    List<Servico> servicos = servicoService.buscarPorPrestadorId(idPrestador);
	    return servicos.stream()
	        .map(servico -> new ServicoDTO(servico))
	        .toList();
	}
	

	public void salvar(PrestadorServicoCadastroDTO dto) {
        prestadorRepository.save(dto.toEntity());
    }
	
	public PrestadorServico getByCode(int id) {
		return prestadorRepository.findById(id).get();
	}
	
	public void delete(Integer id) {
		prestadorRepository.deleteById(id);
	}	
}
