package org.grupo6.main.Ubicacion;

import org.grupo6.main.Ubicacion.DTO.UbicacionDTO;
import org.grupo6.main.Ubicacion.Domain.Ubicacion;
import org.grupo6.main.Ubicacion.Domain.UbicacionService;
import org.grupo6.main.Ubicacion.Infrastructure.UbicacionRepository;
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
public class UbicacionControllerSecurityTest {

    @Mock
    private UbicacionRepository ubicacionRepository;

    @InjectMocks
    private UbicacionService ubicacionService;

    @Test
    public void testGetAllUbicaciones() {
        // Given
        List<Ubicacion> ubicaciones = new ArrayList<>();
        ubicaciones.add(new Ubicacion(1L, "Dirección 1", "Ciudad 1", "País 1"));
        ubicaciones.add(new Ubicacion(2L, "Dirección 2", "Ciudad 2", "País 2"));
        when(ubicacionRepository.findAll()).thenReturn(ubicaciones);

        // When
        List<UbicacionDTO> ubicacionDTOs = ubicacionService.getAllUbicaciones();

        // Then
        assertEquals(ubicaciones.size(), ubicacionDTOs.size());
        assertEquals(ubicaciones.stream().map(Ubicacion::getId).collect(Collectors.toList()),
                ubicacionDTOs.stream().map(UbicacionDTO::getId).collect(Collectors.toList()));
    }

    @Test
    public void testCreateUbicacion() {
        // Given
        UbicacionDTO ubicacionDTO = new UbicacionDTO(null, "Dirección 1", "Ciudad 1", "País 1");
        Long idGenerado = 1L; // ID simulado

        // Configurar el mock para que devuelva una nueva instancia de Ubicacion con un id simulado al guardar
        Ubicacion ubicacionGuardada = new Ubicacion(idGenerado, ubicacionDTO.getDireccion(), ubicacionDTO.getCiudad(), ubicacionDTO.getPais());
        when(ubicacionRepository.save(any(Ubicacion.class))).thenReturn(ubicacionGuardada);

        // When
        UbicacionDTO createdUbicacionDTO = ubicacionService.createUbicacion(ubicacionDTO);

        // Then
        assertNotNull(createdUbicacionDTO);
        assertEquals(idGenerado, createdUbicacionDTO.getId());
        assertEquals(ubicacionDTO.getDireccion(), createdUbicacionDTO.getDireccion());
        assertEquals(ubicacionDTO.getCiudad(), createdUbicacionDTO.getCiudad());
        assertEquals(ubicacionDTO.getPais(), createdUbicacionDTO.getPais());

        // Verificar que el método save del repositorio se haya llamado con el objeto de Ubicacion correcto
        verify(ubicacionRepository, times(1)).save(any(Ubicacion.class));
    }
    @Test
    public void testGetUbicacionById() {
        // Given
        Long ubicacionId = 1L;
        Ubicacion ubicacion = new Ubicacion(ubicacionId, "Dirección 1", "Ciudad 1", "País 1");
        when(ubicacionRepository.findById(ubicacionId)).thenReturn(Optional.of(ubicacion));

        // When
        UbicacionDTO ubicacionDTO = ubicacionService.getUbicacionById(ubicacionId);

        // Then
        assertEquals(ubicacion.getId(), ubicacionDTO.getId());
        assertEquals(ubicacion.getDireccion(), ubicacionDTO.getDireccion());
        assertEquals(ubicacion.getCiudad(), ubicacionDTO.getCiudad());
        assertEquals(ubicacion.getPais(), ubicacionDTO.getPais());
    }

    @Test
    void testUpdateUbicacion() {
        // Given
        Long ubicacionId = 1L;
        Ubicacion ubicacion = new Ubicacion(ubicacionId, "Calle Principal", "Ciudad", "Pais");
        UbicacionDTO ubicacionDTO = new UbicacionDTO(ubicacionId, "Nueva Calle", "Nueva Ciudad", "Nuevo Pais");
        when(ubicacionRepository.findById(ubicacionId)).thenReturn(Optional.of(ubicacion));
        when(ubicacionRepository.save(any(Ubicacion.class))).thenReturn(ubicacion);

        // When
        UbicacionDTO updatedUbicacionDTO = ubicacionService.updateUbicacion(ubicacionId, ubicacionDTO);

        // Then
        assertNotNull(updatedUbicacionDTO);
        assertEquals(ubicacionDTO.getId(), updatedUbicacionDTO.getId());
        assertEquals(ubicacionDTO.getDireccion(), updatedUbicacionDTO.getDireccion());
        assertEquals(ubicacionDTO.getCiudad(), updatedUbicacionDTO.getCiudad());
        assertEquals(ubicacionDTO.getPais(), updatedUbicacionDTO.getPais());
    }

    @Test
    void testDeleteUbicacion() {
        // Given
        Long ubicacionId = 1L;
        Ubicacion ubicacion = new Ubicacion(ubicacionId, "Calle Principal", "Ciudad", "Pais");
        when(ubicacionRepository.findById(ubicacionId)).thenReturn(Optional.of(ubicacion));

        // When
        ubicacionService.deleteUbicacion(ubicacionId);

        // Then
        verify(ubicacionRepository, times(1)).delete(ubicacion);
    }
}