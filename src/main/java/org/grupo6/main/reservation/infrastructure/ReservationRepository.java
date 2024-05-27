package org.grupo6.main.reservation.infrastructure;

import org.grupo6.main.reservation.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
