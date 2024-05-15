package org.grupo6.main.Resena.Domain;

import org.grupo6.main.Resena.DTO.ResenaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResenaMapper {

    ResenaDTO resenaToResenaDTO(Resena reseña);
}