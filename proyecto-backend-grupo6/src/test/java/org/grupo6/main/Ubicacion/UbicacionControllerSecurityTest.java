package org.grupo6.main.Ubicacion;

import org.grupo6.main.Ubicacion.Domain.Ubicacion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class UbicacionControllerSecurityTest {

    @Test
    public void testConstructorAndGetters() {
        // Creamos una instancia de Ubicacion
        Ubicacion ubicacion = new Ubicacion();
        ubicacion.setId(1L);
        ubicacion.setNombre("Restaurante A");

        // Creamos algunas experiencias simuladas
        Experiencia experiencia1 = new Experiencia();
        experiencia1.setId(1L);
        experiencia1.setNombre("Experiencia 1");
        experiencia1.setTipoCocina("Italiana");
        experiencia1.setPrecio("Moderado");

        Experiencia experiencia2 = new Experiencia();
        experiencia2.setId(2L);
        experiencia2.setNombre("Experiencia 2");
        experiencia2.setTipoCocina("Mexicana");
        experiencia2.setPrecio("Económico");

        // Agregamos las experiencias a la ubicación
        List<Experiencia> experiencias = new ArrayList<>();
        experiencias.add(experiencia1);
        experiencias.add(experiencia2);
        ubicacion.setExperiencias(experiencias);

        // Verificamos que los valores se establecieron correctamente
        assertEquals(1L, ubicacion.getId());
        assertEquals("Restaurante A", ubicacion.getNombre());
        assertEquals(2, ubicacion.getExperiencias().size());
        assertEquals("Experiencia 1", ubicacion.getExperiencias().get(0).getNombre());
        assertEquals("Experiencia 2", ubicacion.getExperiencias().get(1).getNombre());
    }
}
