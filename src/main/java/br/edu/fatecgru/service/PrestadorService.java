package br.edu.fatecgru.service;

import java.util.List;

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
    private EstadoService estadoService;
	
	@Autowired
    private CidadeService cidadeService;
	
	@Autowired
	 private UsuarioService usuarioService;
	
	
	
	
	public void cadastrarServico(ServicoCadastroDTO dto, int idPrestador) {
	    Servico servico = new Servico();
        servico.setNome(dto.getNome());
        servico.setDescricao(dto.getDescricao());
        servico.setValor(dto.getValor());
        servico.setCategoria(categoriaService.buscarCategoriaPorId(dto.getIdCategoria()));
        servico.setEstado(estadoService.buscarEstadoPorId(dto.getIdEstado()));
        servico.setServicoCidade(cidadeService.buscarTodasCidadesPorId(dto.getIdsCidades()));
        servico.setPrestadorservico(getByCode(idPrestador));
        servicoService.salvarServico(servico);
    }
	
	public List<ServicoDTO> buscarServicosCriados(int idPrestador){
		return servicoService.buscarPorPrestador(idPrestador);
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
