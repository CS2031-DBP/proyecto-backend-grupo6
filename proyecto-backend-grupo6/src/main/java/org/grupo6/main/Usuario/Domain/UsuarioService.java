package org.grupo6.main.Usuario.Domain;

import org.grupo6.main.Application.dto.UsuarioDTO;
import org.grupo6.main.Infrastructure.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    // Métodos para manejar la lógica de CRUD basados en los métodos del repositorio
}
