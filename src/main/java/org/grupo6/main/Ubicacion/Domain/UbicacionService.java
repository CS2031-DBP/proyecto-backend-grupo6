package org.grupo6.main.Ubicacion.Domain;

import jakarta.transaction.Transactional;
import org.grupo6.main.Exception.UbicacionNotFoundException;
import org.grupo6.main.Ubicacion.DTO.UbicacionDTO;
import org.grupo6.main.Ubicacion.Infrastructure.UbicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UbicacionService {

    @Autowired
    private UbicacionRepository ubicacionRepository;

    @Autowired
    public UbicacionService(UbicacionRepository ubicacionRepository) {
        this.ubicacionRepository = ubicacionRepository;
    }


    public List<UbicacionDTO> getAllUbicaciones() {
        List<Ubicacion> ubicaciones = ubicacionRepository.findAll();
        return ubicaciones.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public UbicacionDTO createUbicacion(UbicacionDTO ubicacionDTO) {
        Ubicacion ubicacion = new Ubicacion();
        ubicacion.setDireccion(ubicacionDTO.getDireccion());
        ubicacion.setCiudad(ubicacionDTO.getCiudad());
        ubicacion.setPais(ubicacionDTO.getPais());

        // Guardar la ubicación en el repositorio y capturar el ID generado
        ubicacion = ubicacionRepository.save(ubicacion);

        // Asignar el ID generado al DTO antes de devolverlo
        ubicacionDTO.setId(ubicacion.getId());

        return ubicacionDTO;
    }
    public UbicacionDTO getUbicacionById(Long id) {
        Ubicacion ubicacion = ubicacionRepository.findById(id)
                .orElseThrow(() -> new UbicacionNotFoundException("Ubicación no encontrada"));
        return convertToDTO(ubicacion);
    }

    @Transactional

    public UbicacionDTO updateUbicacion(Long id, UbicacionDTO ubicacionDTO) {
        Ubicacion ubicacion = ubicacionRepository.findById(id)
                .orElseThrow(() -> new UbicacionNotFoundException("Ubicación no encontrada"));
        ubicacion.setDireccion(ubicacionDTO.getDireccion());
        ubicacion.setCiudad(ubicacionDTO.getCiudad());
        ubicacion.setPais(ubicacionDTO.getPais());
        ubicacionRepository.save(ubicacion);
        return convertToDTO(ubicacion);
    }

    public void deleteUbicacion(Long id) {
        Ubicacion ubicacion = ubicacionRepository.findById(id)
                .orElseThrow(() -> new UbicacionNotFoundException("Ubicación no encontrada"));
        ubicacionRepository.delete(ubicacion);
    }

    private UbicacionDTO convertToDTO(Ubicacion ubicacion) {
        UbicacionDTO ubicacionDTO = new UbicacionDTO();
        ubicacionDTO.setId(ubicacion.getId());
        ubicacionDTO.setDireccion(ubicacion.getDireccion());
        ubicacionDTO.setCiudad(ubicacion.getCiudad());
        ubicacionDTO.setPais(ubicacion.getPais());
        return ubicacionDTO;
    }

    public void setUbicacionRepository(UbicacionRepository ubicacionRepository) {
    }
}