package org.grupo6.main.Restaurante.domain;


import org.grupo6.main.Exception.RestauranteNotFoundException;
import org.grupo6.main.Restaurante.DTO.RestauranteDTO;
import org.grupo6.main.Restaurante.infrastructure.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    public List<RestauranteDTO> getAllRestaurantes() {
        List<Restaurante> restaurantes = restauranteRepository.findAll();
        return restaurantes.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public RestauranteDTO createRestaurante(RestauranteDTO restauranteDTO) {
        Restaurante restaurante = new Restaurante();
        restaurante.setNombre(restauranteDTO.getNombre());
        restaurante.setUbicacion(restauranteDTO.getUbicacion());
        restauranteRepository.save(restaurante);
        return convertToDTO(restaurante);
    }

    public RestauranteDTO getRestauranteById(Long id) {
        Restaurante restaurante = restauranteRepository.findById(id)
                .orElseThrow(() -> new RestauranteNotFoundException("Restaurante no encontrado"));
        return convertToDTO(restaurante);
    }

    public RestauranteDTO updateRestaurante(Long id, RestauranteDTO restauranteDTO) {
        Restaurante restaurante = restauranteRepository.findById(id)
                .orElseThrow(() -> new RestauranteNotFoundException("Restaurante no encontrado"));
        restaurante.setNombre(restauranteDTO.getNombre());
        restaurante.setUbicacion(restauranteDTO.getUbicacion());
        restauranteRepository.save(restaurante);
        return convertToDTO(restaurante);
    }

    public void deleteRestaurante(Long id) {
        Restaurante restaurante = restauranteRepository.findById(id)
                .orElseThrow(() -> new RestauranteNotFoundException("Restaurante no encontrado"));
        restauranteRepository.delete(restaurante);
    }

    private RestauranteDTO convertToDTO(Restaurante restaurante) {
        RestauranteDTO restauranteDTO = new RestauranteDTO();
        restauranteDTO.setId(restaurante.getId());
        restauranteDTO.setNombre(restaurante.getNombre());
        restauranteDTO.setUbicacion(restaurante.getUbicacion());
        return restauranteDTO;
    }
}