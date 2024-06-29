package org.grupo6.main.Evento;
import org.grupo6.main.Evento.DTO.EventoDTO;
import org.grupo6.main.Evento.Infrastructure.EventoRepository;
import org.grupo6.main.Evento.domain.Evento;
import org.grupo6.main.Evento.domain.EventoService;
import org.grupo6.main.Restaurante.domain.Restaurante;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EventoControllerSecurityTest {

    @Mock
    private EventoRepository eventoRepository;

    @InjectMocks
    private EventoService eventoService;

    @Test
    public void testGetAllEventos() {
        // Given
        List<Evento> eventos = new ArrayList<>();
        eventos.add(new Evento(1L, new Restaurante(), "Evento 1", null, 100));
        eventos.add(new Evento(2L, new Restaurante(), "Evento 2", null, 150));
        when(eventoRepository.findAll()).thenReturn(eventos);

        // When
        List<EventoDTO> eventoDTOs = eventoService.getAllEventos();

        // Then
        assertEquals(eventos.size(), eventoDTOs.size());
        assertEquals(eventos.stream().map(Evento::getId).collect(Collectors.toList()),
                eventoDTOs.stream().map(EventoDTO::getId).collect(Collectors.toList()));
    }

    @Test
    public void testCreateEvento() {
        // Given
        Restaurante restaurante = new Restaurante(); // Crea un restaurante simulado
        EventoDTO eventoDTO = new EventoDTO(null, restaurante, "Nuevo Evento", null, 200);
        Evento eventoConId = new Evento(1L, restaurante, "Nuevo Evento", null, 200);
        when(eventoRepository.save(any(Evento.class))).thenAnswer(invocation -> {
            Evento evento = invocation.getArgument(0);
            evento.setId(1L); // Asigna el ID manualmente en el mock
            return evento;
        });

        // When
        EventoDTO createdEventoDTO = eventoService.createEvento(eventoDTO);

        // Then
        assertNotNull(createdEventoDTO, "El DTO creado no debería ser nulo");
        assertNotNull(createdEventoDTO.getId(), "El ID del DTO creado no debería ser nulo");
        assertEquals(eventoDTO.getNombre(), createdEventoDTO.getNombre());
        assertEquals(eventoDTO.getCapacidad(), createdEventoDTO.getCapacidad());
    }

    @Test
    public void testGetEventoById() {
        // Given
        Long id = 1L;
        Evento evento = new Evento(id, new Restaurante(), "Evento 1", null, 100);
        when(eventoRepository.findById(id)).thenReturn(Optional.of(evento));

        // When
        EventoDTO eventoDTO = eventoService.getEventoById(id);

        // Then
        assertNotNull(eventoDTO);
        assertEquals(id, eventoDTO.getId());
        assertEquals(evento.getNombre(), eventoDTO.getNombre());
    }

    @Test
    public void testUpdateEvento() {
        // Given
        Long id = 1L;
        EventoDTO eventoDTO = new EventoDTO(id, new Restaurante(), "Evento Actualizado", null, 300);
        Evento evento = new Evento(id, new Restaurante(), "Evento Actualizado", null, 300);
        when(eventoRepository.findById(id)).thenReturn(Optional.of(evento));
        when(eventoRepository.save(any(Evento.class))).thenReturn(evento);

        // When
        EventoDTO updatedEventoDTO = eventoService.updateEvento(id, eventoDTO);

        // Then
        assertNotNull(updatedEventoDTO);
        assertEquals(id, updatedEventoDTO.getId());
        assertEquals(eventoDTO.getNombre(), updatedEventoDTO.getNombre());
        assertEquals(eventoDTO.getCapacidad(), updatedEventoDTO.getCapacidad());
    }
    @Test
    public void testDeleteEvento() {
        // Given
        Long id = 1L;
        Evento evento = new Evento(id, new Restaurante(), "Evento 1", null, 100);
        when(eventoRepository.findById(id)).thenReturn(Optional.of(evento));

        // When
        eventoService.deleteEvento(id);

        // Then
        verify(eventoRepository, times(1)).delete(evento);
    }
}