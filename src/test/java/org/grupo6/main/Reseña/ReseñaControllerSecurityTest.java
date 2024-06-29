package org.grupo6.main.Reseña;


import org.grupo6.main.Reseña.DTO.ReseñaDTO;
import org.grupo6.main.Reseña.Domain.Reseña;
import org.grupo6.main.Reseña.Domain.ReseñaService;
import org.grupo6.main.Reseña.Infrastructure.ReseñaRepository;
import org.grupo6.main.Restaurante.domain.Restaurante;
import org.grupo6.main.Usuario.Domain.Usuario;
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
public class ReseñaControllerSecurityTest {

    @Mock
    private ReseñaRepository reseñaRepository;

    @InjectMocks
    private ReseñaService reseñaService;

    @Test
    public void testGetAllReseñas() {
        // Given
        List<Reseña> reseñas = new ArrayList<>();
        reseñas.add(new Reseña(1L, new Usuario(), new Restaurante(), 4, "Buena comida"));
        reseñas.add(new Reseña(2L, new Usuario(), new Restaurante(), 5, "Excelente servicio"));
        when(reseñaRepository.findAll()).thenReturn(reseñas);

        // When
        List<ReseñaDTO> reseñaDTOs = reseñaService.getAllReseñas();

        // Then
        assertEquals(reseñas.size(), reseñaDTOs.size());
        assertEquals(reseñas.stream().map(Reseña::getId).collect(Collectors.toList()),
                reseñaDTOs.stream().map(ReseñaDTO::getId).collect(Collectors.toList()));
    }

    @Test
    public void testCreateReseña() {
        // Given
        Usuario usuario = new Usuario();
        usuario.setId(1L); // Configuramos el ID del usuario

        Restaurante restaurante = new Restaurante();
        restaurante.setId(1L); // Configuramos el ID del restaurante

        ReseñaDTO reseñaDTO = new ReseñaDTO(null, usuario, restaurante, 5, "Muy bueno");

        // Aquí configuramos el comportamiento del repositorio mock
        Reseña reseña = new Reseña();
        reseña.setId(1L); // Supongamos que este es el ID que esperamos que tenga la reseña creada
        when(reseñaRepository.save(any(Reseña.class))).thenAnswer(invocation -> {
            Reseña savedReseña = invocation.getArgument(0);
            savedReseña.setId(1L); // Asignamos un ID al objeto Reseña guardado
            return savedReseña;
        });

        // When
        ReseñaDTO createdReseñaDTO = reseñaService.createReseña(reseñaDTO);

        // Then
        assertEquals(reseña.getId(), createdReseñaDTO.getId());
        assertEquals(usuario.getId(), createdReseñaDTO.getUsuario().getId());
        assertEquals(restaurante.getId(), createdReseñaDTO.getRestaurante().getId());
        assertEquals(5, createdReseñaDTO.getValoracion());
        assertEquals("Muy bueno", createdReseñaDTO.getComentario());
    }
    @Test
    public void testGetReseñaById() {
        // Given
        Long reseñaId = 1L;
        Reseña reseña = new Reseña(reseñaId, new Usuario(), new Restaurante(), 4, "Buena comida");
        when(reseñaRepository.findById(reseñaId)).thenReturn(Optional.of(reseña));

        // When
        ReseñaDTO reseñaDTO = reseñaService.getReseñaById(reseñaId);

        // Then
        assertEquals(reseña.getId(), reseñaDTO.getId());
        assertEquals(reseña.getUsuario(), reseñaDTO.getUsuario());
        assertEquals(reseña.getRestaurante(), reseñaDTO.getRestaurante());
        assertEquals(reseña.getValoracion(), reseñaDTO.getValoracion());
        assertEquals(reseña.getComentario(), reseñaDTO.getComentario());
    }

    @Test
    void testUpdateReseña() {
        // Given
        Reseña reseña = new Reseña();
        reseña.setId(1L);
        // Simulamos la búsqueda de la reseña por su ID
        when(reseñaRepository.findById(1L)).thenReturn(Optional.of(reseña));

        ReseñaDTO reseñaDTO = new ReseñaDTO();
        reseñaDTO.setId(1L);
        // Supongamos que modificamos algunos detalles de la reseña
        reseñaDTO.setComentario("Este es un comentario actualizado");

        // When
        ReseñaDTO updatedReseñaDTO = reseñaService.updateReseña(1L, reseñaDTO);

        // Then
        assertNotNull(updatedReseñaDTO);
        assertEquals(reseña.getId(), updatedReseñaDTO.getId());
        assertEquals(reseñaDTO.getComentario(), updatedReseñaDTO.getComentario());
        // Verificamos que el método save del repositorio se haya llamado una vez
        verify(reseñaRepository, times(1)).save(reseña);
    }

    @Test
    void testDeleteReseña() {
        // Given
        Reseña reseña = new Reseña();
        reseña.setId(1L);
        // Simulamos la búsqueda de la reseña por su ID
        when(reseñaRepository.findById(1L)).thenReturn(Optional.of(reseña));

        // When
        reseñaService.deleteReseña(1L);

        // Then
        // Verificamos que el método delete del repositorio se haya llamado una vez con la reseña
        verify(reseñaRepository, times(1)).delete(reseña);
    }
}