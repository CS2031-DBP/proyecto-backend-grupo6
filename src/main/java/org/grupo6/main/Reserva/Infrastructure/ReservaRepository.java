package org.grupo6.main.Reserva.Infrastructure;

import org.grupo6.main.Reserva.Domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}