package org.grupo6.main.promotion.application;


import org.grupo6.main.promotion.domain.PromotionService;
import org.grupo6.main.promotion.dto.PromotionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/promotiones")
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

    @GetMapping
    public List<PromotionDto> getAllPromotiones() {
        return promotionService.getAllPromotiones();
    }

    @PostMapping
    public PromotionDto createPromotion(@RequestBody PromotionDto promotionDto) {
        return promotionService.createPromotion(promotionDto);
    }

    @GetMapping("/{id}")
    public PromotionDto getPromotionById(@PathVariable Long id) {
        return promotionService.getPromotionById(id);
    }

    @PutMapping("/{id}")
    public PromotionDto updatePromotion(@PathVariable Long id, @RequestBody PromotionDto promotionDto) {
        return promotionService.updatePromotion(id, promotionDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePromotion(@PathVariable Long id) {
        promotionService.deletePromotion(id);
        return ResponseEntity.noContent().build();
    }
}
