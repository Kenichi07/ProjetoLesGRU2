package br.edu.fatecgru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.fatecgru.model.entity.repository.AdministradorRepository;
import br.edu.fatecgru.model.entity.repository.CursoRepository;
import br.edu.fatecgru.model.entity.repository.UsuarioRepository;

@Service
public class AdministradorService {

	@Autowired
	private AdministradorRepository administradorRepository;

    @Autowired
    private UsuarioService usuarioService;
}
