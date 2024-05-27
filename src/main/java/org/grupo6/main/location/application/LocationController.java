package org.grupo6.main.location.application;

import org.grupo6.main.location.domain.LocationService;
import org.grupo6.main.location.dto.LocationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/ubicaciones")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @GetMapping
    public List<LocationDto> getAllUbicaciones() {
        return locationService.getAllLocationes();
    }

    @PostMapping
    public LocationDto createUbicacion(@RequestBody LocationDto ubicacionDTO) {
        return locationService.createLocation(ubicacionDTO);
    }
/*
    @GetMapping("/{id}")
    public LocationDto getUbicacionById(@PathVariable Long id) {
        return locationService.getUbicacionById(id);
    }

    @PutMapping("/{id}")
    public LocationDto updateUbicacion(@PathVariable Long id, @RequestBody LocationDto ubicacionDTO) {
        return locationService.updateUbicacion(id, ubicacionDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUbicacion(@PathVariable Long id) {
        locationService.deleteUbicacion(id);
        return ResponseEntity.noContent().build();
    }*/
}
