package org.grupo6.main.Evento.Infrastructure;

import org.grupo6.main.Evento.domain.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}