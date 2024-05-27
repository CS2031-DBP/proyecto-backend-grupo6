package org.grupo6.main.restaurant.dto;

public class RestaurantDto {
    private Long id;
    private String nombre;
    private Long ubicacionId;

    // Getters y setters

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Long getUbicacionId() {
        return ubicacionId;
    }

    public void setUbicacionId(Long ubicacionId) {
        this.ubicacionId = ubicacionId;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(Long id) {
        this.id = id;
    }
/*
    public Ubicacion getUbicacion() {
    }

    public void setUbicacion(Ubicacion ubicacion) {
    }*/
}
