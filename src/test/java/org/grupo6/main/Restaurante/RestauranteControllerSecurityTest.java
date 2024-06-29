package org.grupo6.main.Restaurante;


import org.grupo6.main.Restaurante.DTO.RestauranteDTO;
import org.grupo6.main.Restaurante.domain.Restaurante;
import org.grupo6.main.Restaurante.domain.RestauranteService;
import org.grupo6.main.Restaurante.infrastructure.RestauranteRepository;
import org.grupo6.main.Ubicacion.Domain.Ubicacion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RestauranteControllerSecurityTest {

    @Mock
    private RestauranteRepository restauranteRepository;

    @InjectMocks
    private RestauranteService restauranteService;

    @Test
    public void testGetAllRestaurantes() {
        // Given
        List<Restaurante> restaurantes = new ArrayList<>();
        restaurantes.add(new Restaurante(1L, "Restaurante 1", "Ubicacion 1"));
        restaurantes.add(new Restaurante(2L, "Restaurante 2", "Ubicacion 2"));
        when(restauranteRepository.findAll()).thenReturn(restaurantes);

        // When
        List<RestauranteDTO> restauranteDTOs = restauranteService.getAllRestaurantes();

        // Then
        assertEquals(restaurantes.size(), restauranteDTOs.size());
        assertEquals(restaurantes.stream().map(Restaurante::getId).collect(Collectors.toList()),
                restauranteDTOs.stream().map(RestauranteDTO::getId).collect(Collectors.toList()));
    }

    @Test
    public void testCreateRestaurante() {
        // Given
        RestauranteDTO restauranteDTO = new RestauranteDTO(null, "Nuevo Restaurante", "Nueva Ubicación");
        Restaurante restaurante = new Restaurante(null, "Nuevo Restaurante", "Nueva Ubicación");
        when(restauranteRepository.save(any(Restaurante.class))).thenReturn(restaurante);

        // When
        RestauranteDTO createdRestauranteDTO = restauranteService.createRestaurante(restauranteDTO);

        // Then
        assertNotNull(createdRestauranteDTO);
        assertEquals(restauranteDTO.getNombre(), createdRestauranteDTO.getNombre());
        assertEquals(restauranteDTO.getUbicacion(), createdRestauranteDTO.getUbicacion());
    }

    @Test
    public void testGetRestauranteById() {
        // Given
        Long id = 1L;
        Ubicacion ubicacion = mock(Ubicacion.class); // Crea una instancia mock de Ubicacion
        Restaurante restaurante = new Restaurante(id, "Restaurante 1", ubicacion);
        when(restauranteRepository.findById(id)).thenReturn(Optional.of(restaurante));
        // When
        RestauranteDTO restauranteDTO = restauranteService.getRestauranteById(id);

        // Then
        assertNotNull(restauranteDTO);
        assertEquals(id, restauranteDTO.getId());
        assertEquals(restaurante.getNombre(), restauranteDTO.getNombre());
        assertEquals(restaurante.getUbicacion(), restauranteDTO.getUbicacion());
    }

    @Test
    public void testUpdateRestaurante() {
        // Given
        Long id = 1L;
        Ubicacion ubicacion = mock(Ubicacion.class); // Crea una instancia mock de Ubicacion
        Restaurante existingRestaurante = new Restaurante(id, "Restaurante Existente", ubicacion);
        RestauranteDTO restauranteDTO = new RestauranteDTO(id, "Restaurante Actualizado", ubicacion);
        Restaurante updatedRestaurante = new Restaurante(id, "Restaurante Actualizado", ubicacion);

        when(restauranteRepository.findById(id)).thenReturn(Optional.of(existingRestaurante));
        when(restauranteRepository.save(any(Restaurante.class))).thenReturn(updatedRestaurante);

        // When
        RestauranteDTO updatedRestauranteDTO = restauranteService.updateRestaurante(id, restauranteDTO);

        // Then
        assertNotNull(updatedRestauranteDTO); // Esta línea no falla
        assertEquals(id, updatedRestauranteDTO.getId()); // Esta es la línea 98 que falla
        assertEquals(restauranteDTO.getNombre(), updatedRestauranteDTO.getNombre());
        assertEquals(restauranteDTO.getUbicacion(), updatedRestauranteDTO.getUbicacion());
    }
    @Test
    public void testDeleteRestaurante() {
        // Given
        Long id = 1L;
        Restaurante restaurante = new Restaurante(id, "Restaurante 1", "Ubicacion 1");
        when(restauranteRepository.findById(id)).thenReturn(Optional.of(restaurante));

        // When
        restauranteService.deleteRestaurante(id);

        // Then
        verify(restauranteRepository, times(1)).delete(restaurante);
    }
}