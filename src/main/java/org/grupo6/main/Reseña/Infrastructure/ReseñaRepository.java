package org.grupo6.main.Reseña.Infrastructure;

import org.grupo6.main.Reseña.Domain.Reseña;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReseñaRepository extends JpaRepository<Reseña, Long> {
}