package org.grupo6.main.Usuario.Infrastructure;

import org.grupo6.main.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Métodos de búsqueda específicos, si son necesarios
}
