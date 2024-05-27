package org.grupo6.main.promotion.domain;


import org.grupo6.main.exceptions.PromotionNotFoundException;
import org.grupo6.main.promotion.dto.PromotionDto;
import org.grupo6.main.promotion.infrastructure.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class PromotionService {

    @Autowired
    private PromotionRepository promotionRepository;

    public List<PromotionDto> getAllPromotiones() {
        List<Promotion> promotiones = promotionRepository.findAll();
        return promotiones.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public PromotionDto createPromotion(PromotionDto promotionDto) {
        Promotion promotion = new Promotion();
        promotion.setRestaurant(promotionDto.getRestaurant());
        promotion.setDescripcion(promotionDto.getDescripcion());
        promotion.setFechaInicio(promotionDto.getFechaInicio());
        promotion.setFechaFin(promotionDto.getFechaFin());
        promotionRepository.save(promotion);
        return convertToDto(promotion);
    }

    public PromotionDto getPromotionById(Long id) {
        Promotion promotion = promotionRepository.findById(id)
                .orElseThrow(() -> new PromotionNotFoundException("Promoción no encontrada"));
        return convertToDto(promotion);
    }

    public PromotionDto updatePromotion(Long id, PromotionDto promotionDto) {
        Promotion promotion = promotionRepository.findById(id)
                .orElseThrow(() -> new PromotionNotFoundException("Promoción no encontrada"));
        promotion.setRestaurant(promotionDto.getRestaurant());
        promotion.setDescripcion(promotionDto.getDescripcion());
        promotion.setFechaInicio(promotionDto.getFechaInicio());
        promotion.setFechaFin(promotionDto.getFechaFin());
        promotionRepository.save(promotion);
        return convertToDto(promotion);
    }

    public void deletePromotion(Long id) {
        Promotion promotion = promotionRepository.findById(id)
                .orElseThrow(() -> new PromotionNotFoundException("Promoción no encontrada"));
        promotionRepository.delete(promotion);
    }

    private PromotionDto convertToDto(Promotion promotion) {
        PromotionDto promotionDto = new PromotionDto();
        promotionDto.setId(promotion.getId());
        promotionDto.setRestaurantId(promotion.getRestaurant().getId());
        promotionDto.setDescripcion(promotion.getDescripcion());
        promotionDto.setFechaInicio(promotion.getFechaInicio());
        promotionDto.setFechaFin(promotion.getFechaFin());
        return promotionDto;
    }
}
