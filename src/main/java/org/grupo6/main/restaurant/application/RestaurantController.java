package org.grupo6.main.restaurant.application;

import org.grupo6.main.restaurant.domain.RestaurantService;
import org.grupo6.main.restaurant.dto.RestaurantDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;
    /*
    @GetMapping
    public List<RestaurantDto> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @PostMapping
    public RestaurantDto createRestaurant(@RequestBody RestaurantDto restaurantDTO) {
        return restaurantService.createRestaurant(restaurantDTO);
    }

    @GetMapping("/{id}")
    public RestaurantDto getRestaurantById(@PathVariable Long id) {
        return restaurantService.getRestaurantById(id);
    }

    @PutMapping("/{id}")
    public RestaurantDto updateRestaurant(@PathVariable Long id, @RequestBody RestaurantDto restaurantDTO) {
        return restaurantService.updateRestaurant(id, restaurantDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.noContent().build();
    }*/
}
