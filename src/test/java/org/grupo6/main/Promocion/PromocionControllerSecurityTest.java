package org.grupo6.main.Promocion;

import org.grupo6.main.Promocion.DTO.PromocionDTO;
import org.grupo6.main.Promocion.Infrastructure.PromocionRepository;
import org.grupo6.main.Promocion.domain.Promocion;
import org.grupo6.main.Promocion.domain.PromocionService;
import org.grupo6.main.Restaurante.infrastructure.RestauranteRepository;
import org.grupo6.main.Usuario.Infrastructure.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;




@ExtendWith(MockitoExtension.class)
public class PromocionControllerSecurityTest {

    @Mock
    private PromocionRepository promocionRepository;

    @Mock
    private RestauranteRepository restauranteRepository;

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private PromocionService promocionService;

    @Test
    public void testGetAllPromociones() {
        // Given
        List<Promocion> promociones = new ArrayList<>();
        promociones.add(new Promocion(1L, "Promoción 1", null, null, new ArrayList<>(), new ArrayList<>()));
        promociones.add(new Promocion(2L, "Promoción 2", null, null, new ArrayList<>(), new ArrayList<>()));
        when(promocionRepository.findAll()).thenReturn(promociones);

        // When
        List<PromocionDTO> promocionDTOs = promocionService.getAllPromociones();

        // Then
        assertEquals(promociones.size(), promocionDTOs.size());
        assertEquals(promociones.stream().map(Promocion::getId).collect(Collectors.toList()),
                promocionDTOs.stream().map(PromocionDTO::getId).collect(Collectors.toList()));
    }

    @Test
    public void testCreatePromocion() {
        // Given
        PromocionDTO promocionDTO = new PromocionDTO(null, "Nueva Promoción", null, null, new ArrayList<>(), new ArrayList<>());
        Promocion promocion = new Promocion(null, "Nueva Promoción", null, null, new ArrayList<>(), new ArrayList<>());

        // Configuración del comportamiento de los mocks
        doReturn(new ArrayList<>()).when(restauranteRepository).findAllById(anyList());
        doReturn(new ArrayList<>()).when(usuarioRepository).findAllById(anyList());
        doReturn(promocion).when(promocionRepository).save(any(Promocion.class));

        // When
        PromocionDTO createdPromocionDTO = promocionService.createPromocion(promocionDTO);

        // Then
        assertNotNull(createdPromocionDTO);
        assertEquals(promocionDTO.getDescripcion(), createdPromocionDTO.getDescripcion());

        // Verificamos que se haya llamado al método save en el repositorio con la promoción
        verify(promocionRepository, times(1)).save(any(Promocion.class));
    }

    @Test
    public void testGetPromocionById() {
        // Given
        Long id = 1L;
        Promocion promocion = new Promocion(id, "Promoción 1", null, null, new ArrayList<>(), new ArrayList<>());
        when(promocionRepository.findById(id)).thenReturn(Optional.of(promocion));

        // When
        PromocionDTO promocionDTO = promocionService.getPromocionById(id);

        // Then
        assertNotNull(promocionDTO);
        assertEquals(id, promocionDTO.getId());
        assertEquals(promocion.getDescripcion(), promocionDTO.getDescripcion());

        // Verificamos que se haya llamado al método findById en el repositorio
        verify(promocionRepository, times(1)).findById(id);
    }

    @Test
    public void testUpdatePromocion() {
        // Given
        Long id = 1L;
        PromocionDTO promocionDTO = new PromocionDTO(id, "Promoción Actualizada", null, null, new ArrayList<>(), new ArrayList<>());
        Promocion promocion = new Promocion(id, "Promoción Actualizada", null, null, new ArrayList<>(), new ArrayList<>());
        when(promocionRepository.findById(id)).thenReturn(Optional.of(promocion));
        when(restauranteRepository.findAllById(anyList())).thenReturn(new ArrayList<>());
        when(usuarioRepository.findAllById(anyList())).thenReturn(new ArrayList<>());
        when(promocionRepository.save(any(Promocion.class))).thenReturn(promocion);

        // When
        PromocionDTO updatedPromocionDTO = promocionService.updatePromocion(id, promocionDTO);

        // Then
        assertNotNull(updatedPromocionDTO);
        assertEquals(id, updatedPromocionDTO.getId());
        assertEquals(promocionDTO.getDescripcion(), updatedPromocionDTO.getDescripcion());

        // Verificamos que se haya llamado al método save en el repositorio con la promoción actualizada
        verify(promocionRepository, times(1)).save(any(Promocion.class));
    }

    @Test
    public void testDeletePromocion() {
        // Given
        Long id = 1L;
        Promocion promocion = new Promocion(id, "Promoción 1", null, null, new ArrayList<>(), new ArrayList<>());
        when(promocionRepository.findById(id)).thenReturn(Optional.of(promocion));

        // When
        promocionService.deletePromocion(id);

        // Then
        verify(promocionRepository, times(1)).delete(promocion);
    }
}