package org.grupo6.main.Restaurante.domain;

import org.grupo6.main.Exception.RestauranteNotFoundException;
import org.grupo6.main.Restaurante.DTO.RestauranteDTO;
import org.grupo6.main.Restaurante.infrastructure.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    public Page<RestauranteDTO> getRestaurantesPaginados(int page, int size) {
        Page<Restaurante> restaurantes = restauranteRepository.findAll(PageRequest.of(page, size));
        return restaurantes.map(this::convertToDTO);
    }

    public RestauranteDTO createRestaurante(RestauranteDTO restauranteDTO) {
        Restaurante restaurante = new Restaurante();
        restaurante.setNombre(restauranteDTO.getNombre());
        restaurante.setUbicacion(restauranteDTO.getUbicacion());
        System.out.println("Recibido RestauranteDTO: " + restauranteDTO); // Log DTO recibido
        restauranteRepository.save(restaurante);
        System.out.println("Guardado Restaurante: " + restaurante); // Log entidad guardada
        return convertToDTO(restaurante);
    }

    private RestauranteDTO convertToDTO(Restaurante restaurante) {
        RestauranteDTO restauranteDTO = new RestauranteDTO();
        restauranteDTO.setId(restaurante.getId());
        restauranteDTO.setNombre(restaurante.getNombre());
        restauranteDTO.setUbicacion(restaurante.getUbicacion());
        System.out.println("Convertido RestauranteDTO: " + restauranteDTO); // Log DTO convertido
        return restauranteDTO;
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
}
