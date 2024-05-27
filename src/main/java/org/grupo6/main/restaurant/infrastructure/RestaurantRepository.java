package org.grupo6.main.restaurant.infrastructure;

import org.grupo6.main.restaurant.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}