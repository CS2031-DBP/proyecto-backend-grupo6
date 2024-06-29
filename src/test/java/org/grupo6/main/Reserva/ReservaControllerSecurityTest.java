package org.grupo6.main.Reserva;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.grupo6.main.Exception.ReservaNotFoundException;
import org.grupo6.main.Reserva.DTO.ReservaDTO;
import org.grupo6.main.Reserva.Domain.Reserva;
import org.grupo6.main.Reserva.Domain.ReservaService;
import org.grupo6.main.Reserva.Infrastructure.ReservaRepository;
import org.grupo6.main.Restaurante.domain.Restaurante;
import org.grupo6.main.Usuario.Domain.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class ReservaControllerSecurityTest {

    @Mock
    private ReservaRepository reservaRepository;

    @InjectMocks
    private ReservaService reservaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllReservas() {
        // Arrange
        List<Reserva> reservas = new ArrayList<>();
        reservas.add(new Reserva());
        reservas.add(new Reserva());
        when(reservaRepository.findAll()).thenReturn(reservas);

        // Act
        List<ReservaDTO> result = reservaService.getAllReservas();

        // Assert
        assertEquals(2, result.size());
    }

    @Test
    public void testCreateReserva() {
        // Arrange
        ReservaDTO reservaDTO = new ReservaDTO();
        reservaDTO.setUsuario(new Usuario());
        reservaDTO.setRestaurante(new Restaurante());
        reservaDTO.setFechaHora(LocalDateTime.now());
        reservaDTO.setEstado("Reservado");

        Reserva reserva = new Reserva();
        when(reservaRepository.save(any(Reserva.class))).thenReturn(reserva);

        // Act
        ReservaDTO result = reservaService.createReserva(reservaDTO);

        // Assert
        assertNotNull(result);
        assertEquals(reservaDTO.getUsuario(), result.getUsuario());
        assertEquals(reservaDTO.getRestaurante(), result.getRestaurante());
        assertEquals(reservaDTO.getFechaHora(), result.getFechaHora());
        assertEquals(reservaDTO.getEstado(), result.getEstado());
    }

    @Test
    public void testGetReservaById() {
        // Arrange
        Long id = 1L;
        Reserva reserva = new Reserva();
        reserva.setId(id);
        when(reservaRepository.findById(id)).thenReturn(Optional.of(reserva));

        // Act
        ReservaDTO result = reservaService.getReservaById(id);

        // Assert
        assertNotNull(result);
        assertEquals(id, result.getId());
    }
    @Test
    public void testUpdateReserva() {
        // Given
        Long id = 1L;
        LocalDateTime fechaHora = LocalDateTime.now();
        ReservaDTO reservaDTO = new ReservaDTO(id, new Usuario(), new Restaurante(), fechaHora, "Confirmada");
        Reserva reserva = new Reserva(id, new Usuario(), new Restaurante(), fechaHora, "Pendiente");
        when(reservaRepository.findById(id)).thenReturn(Optional.of(reserva));
        when(reservaRepository.save(any(Reserva.class))).thenReturn(reserva);

        // When
        ReservaDTO updatedReservaDTO = reservaService.updateReserva(id, reservaDTO);

        // Then
        assertEquals(reservaDTO.getId(), updatedReservaDTO.getId());
        assertEquals(reservaDTO.getUsuario(), updatedReservaDTO.getUsuario());
        assertEquals(reservaDTO.getRestaurante(), updatedReservaDTO.getRestaurante());
        assertEquals(reservaDTO.getFechaHora(), updatedReservaDTO.getFechaHora());
        assertEquals(reservaDTO.getEstado(), updatedReservaDTO.getEstado());
    }

    @Test
    public void testDeleteReserva() {
        // Given
        Long id = 1L;
        Reserva reserva = new Reserva(id, new Usuario(), new Restaurante(), LocalDateTime.now(), "Pendiente");
        when(reservaRepository.findById(id)).thenReturn(Optional.of(reserva));

        // When
        reservaService.deleteReserva(id);

        // Then
        verify(reservaRepository, times(1)).delete(reserva);
    }

    @Test
    public void testUpdateReservaNotFound() {
        // Given
        Long id = 1L;
        LocalDateTime fechaHora = LocalDateTime.now();
        ReservaDTO reservaDTO = new ReservaDTO(id, new Usuario(), new Restaurante(), fechaHora, "Confirmada");
        when(reservaRepository.findById(id)).thenReturn(Optional.empty());

        // When/Then
        assertThrows(ReservaNotFoundException.class, () -> reservaService.updateReserva(id, reservaDTO));
    }

    @Test
    public void testDeleteReservaNotFound() {
        // Given
        Long id = 1L;
        when(reservaRepository.findById(id)).thenReturn(Optional.empty());

        // When/Then
        assertThrows(ReservaNotFoundException.class, () -> reservaService.deleteReserva(id));
    }
}