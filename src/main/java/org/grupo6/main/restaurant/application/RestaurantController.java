package org.grupo6.main.restaurant.application;

import org.grupo6.main.restaurant.domain.RestaurantService;
import org.grupo6.main.restaurant.dto.RestaurantDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestaurantController {
    @Autowired
    private RestaurantService restauranteService;
    /*
    @GetMapping
    public List<RestaurantDto> getAllRestaurantes() {
        return restauranteService.getAllRestaurants();
    }

    @PostMapping
    public RestaurantDto createRestaurante(@RequestBody RestaurantDto restauranteDTO) {
        return restauranteService.createRestaurante(restauranteDTO);
    }

    @GetMapping("/{id}")
    public RestaurantDto getRestauranteById(@PathVariable Long id) {
        return restauranteService.getRestauranteById(id);
    }

    @PutMapping("/{id}")
    public RestaurantDto updateRestaurante(@PathVariable Long id, @RequestBody RestaurantDto restauranteDTO) {
        return restauranteService.updateRestaurante(id, restauranteDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurante(@PathVariable Long id) {
        restauranteService.deleteRestaurante(id);
        return ResponseEntity.noContent().build();
    }*/
}
