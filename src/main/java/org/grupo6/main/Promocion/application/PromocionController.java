package org.grupo6.main.Promocion.application;

import org.grupo6.main.Promocion.DTO.PromocionDTO;
import org.grupo6.main.Promocion.domain.PromocionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/promociones")
public class PromocionController {

    @Autowired
    private PromocionService promocionService;

    @GetMapping
    public List<PromocionDTO> getAllPromociones() {
        return promocionService.getAllPromociones();
    }

    @PostMapping
    public PromocionDTO createPromocion(@RequestBody PromocionDTO promocionDTO) {
        return promocionService.createPromocion(promocionDTO);
    }

    @GetMapping("/{id}")
    public PromocionDTO getPromocionById(@PathVariable Long id) {
        return promocionService.getPromocionById(id);
    }

    @PutMapping("/{id}")
    public PromocionDTO updatePromocion(@PathVariable Long id, @RequestBody PromocionDTO promocionDTO) {
        return promocionService.updatePromocion(id, promocionDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePromocion(@PathVariable Long id) {
        promocionService.deletePromocion(id);
        return ResponseEntity.noContent().build();
    }
}