package org.grupo6.main.Resena.Infrastructure;

import org.grupo6.main.Resena.Domain.Resena;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResenaRepository extends JpaRepository<Resena, Long> {
    // Aquí podrías agregar métodos adicionales si necesitas realizar consultas personalizadas
}