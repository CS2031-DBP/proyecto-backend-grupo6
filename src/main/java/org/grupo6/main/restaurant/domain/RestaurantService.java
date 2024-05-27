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
        return restaurants.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public RestaurantDto createRestaurant(RestaurantDto restaurantDto) {
        Restaurant restaurant = new Restaurant();
        restaurant.setNombre(restaurantDto.getNombre());

        restaurant.setLocation(restaurantDto.getLocation());
        restaurantRepository.save(restaurant);
        return convertToDto(restaurant);
    }

    public RestaurantDto getRestaurantById(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant no encontrado"));
        return convertToDto(restaurant);
    }

    public RestaurantDto updateRestaurant(Long id, RestaurantDto restaurantDto) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant no encontrado"));
        restaurant.setNombre(restaurantDto.getNombre());
        restaurant.setLocation(restaurantDto.getLocation());
        restaurantRepository.save(restaurant);
        return convertToDto(restaurant);
    }

    public void deleteRestaurant(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant no encontrado"));
        restaurantRepository.delete(restaurant);
    }

    private RestaurantDto convertToDto(Restaurant restaurant) {
        RestaurantDto restaurantDto = new RestaurantDto();
        restaurantDto.setId(restaurant.getId());
        restaurantDto.setNombre(restaurant.getNombre());
        restaurantDto.setLocation(restaurant.getLocation());
        return restaurantDto;
    }
}
