package org.grupo6.main.promotion.infrastructure;

import org.grupo6.main.promotion.domain.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {
}
