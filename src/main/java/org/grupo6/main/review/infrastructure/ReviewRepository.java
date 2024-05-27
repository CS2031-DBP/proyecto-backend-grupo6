package org.grupo6.main.review.infrastructure;

import org.grupo6.main.review.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}