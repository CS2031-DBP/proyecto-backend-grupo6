package org.grupo6.main.location.domain;


import org.grupo6.main.location.dto.LocationDto;
import org.grupo6.main.location.infrastructure.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public List<LocationDto> getAllLocationes() {
        List<Location> ubicaciones = locationRepository.findAll();
        return ubicaciones.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public LocationDto createLocation(LocationDto ubicacionDTO) {
        Location ubicacion = new Location();
        ubicacion.setDireccion(ubicacionDTO.getDireccion());
        ubicacion.setCiudad(ubicacionDTO.getCiudad());
        ubicacion.setPais(ubicacionDTO.getPais());
        locationRepository.save(ubicacion);
        return convertToDTO(ubicacion);
    }
    /*
    public LocationDto getLocationById(Long id) {
        Location ubicacion = locationRepository.findById(id)
                .orElseThrow(() -> new LocationNotFoundException("Ubicación no encontrada"));
        return convertToDTO(ubicacion);
    }

    public LocationDto updateLocation(Long id, LocationDto ubicacionDTO) {
        Location ubicacion = locationRepository.findById(id)
                .orElseThrow(() -> new LocationNotFoundException("Ubicación no encontrada"));
        ubicacion.setDireccion(ubicacionDTO.getDireccion());
        ubicacion.setCiudad(ubicacionDTO.getCiudad());
        ubicacion.setPais(ubicacionDTO.getPais());
        locationRepository.save(ubicacion);
        return convertToDTO(ubicacion);
    }

    public void deleteLocation(Long id) {
        Location ubicacion = locationRepository.findById(id)
                .orElseThrow(() -> new LocationNotFoundException("Ubicación no encontrada"));
        locationRepository.delete(ubicacion);
    }
    */
    private LocationDto convertToDTO(Location ubicacion) {
        LocationDto ubicacionDTO = new LocationDto();
        ubicacionDTO.setId(ubicacion.getId());
        ubicacionDTO.setDireccion(ubicacion.getDireccion());
        ubicacionDTO.setCiudad(ubicacion.getCiudad());
        ubicacionDTO.setPais(ubicacion.getPais());
        return ubicacionDTO;
    }
}
