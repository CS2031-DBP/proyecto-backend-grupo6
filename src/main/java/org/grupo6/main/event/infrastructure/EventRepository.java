package org.grupo6.main.event.infrastructure;

import org.grupo6.main.event.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
