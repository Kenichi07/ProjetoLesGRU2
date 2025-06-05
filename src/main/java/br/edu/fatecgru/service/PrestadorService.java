package br.edu.fatecgru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecgru.DTO.PrestadorServicoCadastroDTO;
import br.edu.fatecgru.model.entity.PrestadorServico;
import br.edu.fatecgru.model.entity.repository.PrestadorServicoRepository;
import br.edu.fatecgru.model.entity.repository.ServicoRepository;

@Service
public class PrestadorService {

	@Autowired
	private PrestadorServicoRepository prestadorRepository;
	
	@Autowired
    private ServicoRepository servicoRepo;
	
	@Autowired
	 private UsuarioService usuarioService;
	
	
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
