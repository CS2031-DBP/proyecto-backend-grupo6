package org.grupo6.main.Reserva;

import org.grupo6.main.Reserva.Domain.Reserva;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

public class ReservaControllerIntegrationTest {

    @Test
    public void testConstructorAndGetters() {
        // Creamos una instancia de Reserva
        Reserva reserva = new Reserva();

        // Establecemos valores para los atributos
        Long id = 1L;
        LocalDateTime fecha = LocalDateTime.now();
        String metodoPago = "Tarjeta de crédito";

        reserva.setId(id);
        reserva.setFecha(fecha);
        reserva.setMetodoPago(metodoPago);

        // Verificamos que los valores se establecieron correctamente
        assertEquals(id, reserva.getId());
        assertEquals(fecha, reserva.getFecha());
        assertEquals(metodoPago, reserva.getMetodoPago());
    }
}
