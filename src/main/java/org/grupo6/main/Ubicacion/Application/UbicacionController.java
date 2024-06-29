package org.grupo6.main.Ubicacion.Application;

import org.grupo6.main.Ubicacion.DTO.UbicacionDTO;
import org.grupo6.main.Ubicacion.Domain.UbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ubicaciones")
public class UbicacionController {

    @Autowired
    private UbicacionService ubicacionService;

    @GetMapping
    public List<UbicacionDTO> getAllUbicaciones() {
        return ubicacionService.getAllUbicaciones();
    }

    @PostMapping
    public UbicacionDTO createUbicacion(@RequestBody UbicacionDTO ubicacionDTO) {
        return ubicacionService.createUbicacion(ubicacionDTO);
    }

    @GetMapping("/{id}")
    public UbicacionDTO getUbicacionById(@PathVariable Long id) {
        return ubicacionService.getUbicacionById(id);
    }

    @PutMapping("/{id}")
    public UbicacionDTO updateUbicacion(@PathVariable Long id, @RequestBody UbicacionDTO ubicacionDTO) {
        return ubicacionService.updateUbicacion(id, ubicacionDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUbicacion(@PathVariable Long id) {
        ubicacionService.deleteUbicacion(id);
        return ResponseEntity.noContent().build();
    }
}