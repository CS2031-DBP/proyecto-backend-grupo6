package org.grupo6.main.Ubicacion.Infrastructure;

import org.grupo6.main.Ubicacion.Domain.Ubicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UbicacionRepository extends JpaRepository<Ubicacion, Long> {

    @Query("SELECT u FROM Ubicacion u JOIN u.experiencias e WHERE (:ubicacion IS NULL OR u.nombre = :ubicacion) " +
            "AND (:tipoCocina IS NULL OR e.tipoCocina = :tipoCocina) " +
            "AND (:precio IS NULL OR e.precio = :precio)")
    List<Ubicacion> buscarExperienciasPorUbicacionTipoCocinaYPrecio(@Param("ubicacion") String ubicacion,
                                                                    @Param("tipoCocina") String tipoCocina,
                                                                    @Param("precio") String precio);
}
