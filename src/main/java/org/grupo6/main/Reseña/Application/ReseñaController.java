package org.grupo6.main.Reseña.Application;

import org.grupo6.main.Reseña.DTO.ReseñaDTO;
import org.grupo6.main.Reseña.Domain.ReseñaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reseñas")
public class ReseñaController {

    @Autowired
    private ReseñaService reseñaService;

    @GetMapping
    public List<ReseñaDTO> getAllReseñas() {
        return reseñaService.getAllReseñas();
    }

    @PostMapping
    public ReseñaDTO createReseña(@RequestBody ReseñaDTO reseñaDTO) {
        return reseñaService.createReseña(reseñaDTO);
    }

    @GetMapping("/{id}")
    public ReseñaDTO getReseñaById(@PathVariable Long id) {
        return reseñaService.getReseñaById(id);
    }

    @PutMapping("/{id}")
    public ReseñaDTO updateReseña(@PathVariable Long id, @RequestBody ReseñaDTO reseñaDTO) {
        return reseñaService.updateReseña(id, reseñaDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReseña(@PathVariable Long id) {
        reseñaService.deleteReseña(id);
        return ResponseEntity.noContent().build();
    }
}