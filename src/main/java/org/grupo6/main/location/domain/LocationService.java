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
        return locations.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public LocationDto createLocation(LocationDto locationDto) {
        Location location = new Location();
        location.setDireccion(locationDto.getDireccion());
        location.setCiudad(locationDto.getCiudad());
        location.setPais(locationDto.getPais());
        locationRepository.save(location);
        return convertToDto(location);
    }

    public LocationDto getLocationById(Long id) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new LocationNotFoundException("Ubicación no encontrada"));
        return convertToDto(location);
    }

    public LocationDto updateLocation(Long id, LocationDto locationDto) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new LocationNotFoundException("Ubicación no encontrada"));
        location.setDireccion(locationDto.getDireccion());
        location.setCiudad(locationDto.getCiudad());
        location.setPais(locationDto.getPais());
        locationRepository.save(location);
        return convertToDto(location);
    }

    public void deleteLocation(Long id) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new LocationNotFoundException("Ubicación no encontrada"));
        locationRepository.delete(location);
    }

    private LocationDto convertToDto(Location location) {
        LocationDto locationDto = new LocationDto();
        locationDto.setId(location.getId());
        locationDto.setDireccion(location.getDireccion());
        locationDto.setCiudad(location.getCiudad());
        locationDto.setPais(location.getPais());
        return locationDto;
    }
}
