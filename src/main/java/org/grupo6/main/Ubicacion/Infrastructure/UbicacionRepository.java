package org.grupo6.main.Ubicacion.Infrastructure;

import org.grupo6.main.Ubicacion.Domain.Ubicacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UbicacionRepository extends JpaRepository<Ubicacion, Long> {
}