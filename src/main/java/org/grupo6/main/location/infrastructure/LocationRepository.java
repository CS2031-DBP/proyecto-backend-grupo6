package org.grupo6.main.location.infrastructure;

import org.grupo6.main.location.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
