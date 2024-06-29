package org.grupo6.main.Promocion.Infrastructure;

import org.grupo6.main.Promocion.domain.Promocion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromocionRepository extends JpaRepository<Promocion, Long> {
}