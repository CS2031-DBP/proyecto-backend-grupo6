package org.grupo6.main.Ubicacion.Domain;


import org.grupo6.main.Ubicacion.DTO.UbicacionDTO;
import org.grupo6.main.Ubicacion.Infrastructure.UbicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UbicacionService {

    private final UbicacionRepository ubicacionRepository;
    private final UbicacionMapper ubicacionMapper;

    @Autowired
    public UbicacionService(UbicacionRepository ubicacionRepository, UbicacionMapper ubicacionMapper) {
        this.ubicacionRepository = ubicacionRepository;
        this.ubicacionMapper = ubicacionMapper;
    }

    public List<UbicacionDTO> buscarExperienciasPorUbicacionTipoCocinaYPrecio(String ubicacion, String tipoCocina, String precio) {
        List<Ubicacion> ubicaciones = ubicacionRepository.buscarExperienciasPorUbicacionTipoCocinaYPrecio(ubicacion, tipoCocina, precio);
        return ubicaciones.stream()
                .map(ubicacionMapper::ubicacionToUbicacionDTO)
                .collect(Collectors.toList());
    }
}
