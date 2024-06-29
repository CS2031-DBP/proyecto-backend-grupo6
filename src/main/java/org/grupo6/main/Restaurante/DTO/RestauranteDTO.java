package org.grupo6.main.Restaurante.DTO;

import org.grupo6.main.Ubicacion.Domain.Ubicacion;

import java.util.ArrayList;

public class RestauranteDTO {
    private Long id;
    private String nombre;
    private Ubicacion ubicacion;



    public RestauranteDTO(Long id, String nuevoRestaurante, Ubicacion nuevaUbicacion) {
        this.id = id;
        this.nombre = nuevoRestaurante;
        this.ubicacion = nuevaUbicacion;
    }
    public RestauranteDTO(){
        
    }

    public RestauranteDTO(Long id, String restauranteActualizado, String ubicaciónActualizada) {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
}
