package org.grupo6.main.Restaurante.infrastructure;

import org.grupo6.main.Restaurante.domain.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
}