package org.grupo6.main.Ubicacion.Domain;

import org.grupo6.main.Ubicacion.Domain.Ubicacion;
import org.grupo6.main.Ubicacion.DTO.UbicacionDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UbicacionMapper {

    UbicacionDTO ubicacionToUbicacionDTO(Ubicacion ubicacion);
}
