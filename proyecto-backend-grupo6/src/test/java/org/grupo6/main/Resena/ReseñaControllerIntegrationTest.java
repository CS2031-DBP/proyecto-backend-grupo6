package org.grupo6.main.Resena;


import org.grupo6.main.Resena.Domain.Resena;
import org.grupo6.main.Reserva.Domain.Reserva;
import org.grupo6.main.Usuario.Domain.Usuario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ResenaTest {

    @Test
    public void testConstructorAndGetters() {
        // Crear instancias de Usuario y Reserva simuladas
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNombre("Usuario1");

        Reserva reserva = new Reserva();
        reserva.setId(1L);
        reserva.setLugar("Restaurante A");

        // Crear una instancia de Resena
        Resena resena = new Resena(usuario, reserva, "¡Excelente comida y servicio!", 5);

        // Verificar que los valores se establecieron correctamente
        assertEquals(usuario, resena.getUsuario());
        assertEquals(reserva, resena.getReserva());
        assertEquals("¡Excelente comida y servicio!", resena.getComentario());
        assertEquals(5, resena.getValoracion());
    }
}
