package org.grupo6.main.restaurant.domain;

import org.grupo6.main.exceptions.RestaurantNotFoundException;
import org.grupo6.main.restaurant.dto.RestaurantDto;
import org.grupo6.main.restaurant.infrastructure.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<RestaurantDto> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        return restaurants.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public RestaurantDto createRestaurant(RestaurantDto restaurantDTO) {
        Restaurant restaurant = new Restaurant();
        restaurant.setNombre(restaurantDTO.getNombre());

        restaurant.setLocation(restaurantDTO.getLocation());
        restaurantRepository.save(restaurant);
        return convertToDTO(restaurant);
    }

    public RestaurantDto getRestaurantById(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant no encontrado"));
        return convertToDTO(restaurant);
    }

    public RestaurantDto updateRestaurant(Long id, RestaurantDto restaurantDTO) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant no encontrado"));
        restaurant.setNombre(restaurantDTO.getNombre());
        restaurant.setLocation(restaurantDTO.getLocation());
        restaurantRepository.save(restaurant);
        return convertToDTO(restaurant);
    }

    public void deleteRestaurant(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant no encontrado"));
        restaurantRepository.delete(restaurant);
    }

    private RestaurantDto convertToDTO(Restaurant restaurant) {
        RestaurantDto restaurantDTO = new RestaurantDto();
        restaurantDTO.setId(restaurant.getId());
        restaurantDTO.setNombre(restaurant.getNombre());
        restaurantDTO.setLocation(restaurant.getLocation());
        return restaurantDTO;
    }
}
