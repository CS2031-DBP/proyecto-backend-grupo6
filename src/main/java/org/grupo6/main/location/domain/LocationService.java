package org.grupo6.main.location.domain;


import org.grupo6.main.exceptions.LocationNotFoundException;
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

    public List<LocationDto> getAllLocations() {
        List<Location> locations = locationRepository.findAll();
        return locations.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public LocationDto createLocation(LocationDto locationDTO) {
        Location location = new Location();
        location.setDireccion(locationDTO.getDireccion());
        location.setCiudad(locationDTO.getCiudad());
        location.setPais(locationDTO.getPais());
        locationRepository.save(location);
        return convertToDTO(location);
    }

    public LocationDto getLocationById(Long id) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new LocationNotFoundException("Ubicación no encontrada"));
        return convertToDTO(location);
    }

    public LocationDto updateLocation(Long id, LocationDto locationDTO) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new LocationNotFoundException("Ubicación no encontrada"));
        location.setDireccion(locationDTO.getDireccion());
        location.setCiudad(locationDTO.getCiudad());
        location.setPais(locationDTO.getPais());
        locationRepository.save(location);
        return convertToDTO(location);
    }

    public void deleteLocation(Long id) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new LocationNotFoundException("Ubicación no encontrada"));
        locationRepository.delete(location);
    }

    private LocationDto convertToDTO(Location location) {
        LocationDto locationDTO = new LocationDto();
        locationDTO.setId(location.getId());
        locationDTO.setDireccion(location.getDireccion());
        locationDTO.setCiudad(location.getCiudad());
        locationDTO.setPais(location.getPais());
        return locationDTO;
    }
}
