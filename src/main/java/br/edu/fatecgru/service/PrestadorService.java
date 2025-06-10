package br.edu.fatecgru.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecgru.DTO.PrestadorServicoCadastroDTO;
import br.edu.fatecgru.DTO.ServicoCadastroDTO;
import br.edu.fatecgru.DTO.ServicoDTO;
import br.edu.fatecgru.model.entity.PrestadorServico;
import br.edu.fatecgru.model.entity.Servico;
import br.edu.fatecgru.model.entity.repository.PrestadorServicoRepository;
import br.edu.fatecgru.model.entity.repository.ServicoRepository;

@Service
public class PrestadorService {

	@Autowired
	private PrestadorServicoRepository prestadorRepository;
	
	@Autowired
    private ServicoService servicoService;
	
	@Autowired ServicoRepository servicoRepository;
	
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
		return servicoRepository.findByPrestadorservicoId(idPrestador)
                .stream()
                .map(ServicoDTO::new)
                .collect(Collectors.toList());
	}
	

	public void salvar(PrestadorServicoCadastroDTO dto) {
        prestadorRepository.save(dto.toEntity());
    }
	public void salvar(PrestadorServico entity) {
        prestadorRepository.save(entity);
    }
	
	public PrestadorServico getByCode(int id) {
		return prestadorRepository.findById(id).get();
	}
	
	public void delete(Integer id) {
		prestadorRepository.deleteById(id);
	}	
}
