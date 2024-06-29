package org.grupo6.main.Evento.DTO;

import org.grupo6.main.Restaurante.domain.Restaurante;

import java.util.Date;

public class EventoDTO {
    private Long id;
    private String nombre;
    private Date fecha;
    private Restaurante restaurante;
    private int capacidad;

    public EventoDTO(Object o, Restaurante restaurante, String nuevoEvento, Object o1, int i) {
    }

    public EventoDTO(){

    }
    public EventoDTO(Long id, Restaurante restaurante, String nombre, Date fecha, int capacidad) {
        this.id = id;
        this.restaurante = restaurante;
        this.nombre = nombre;
        this.fecha = fecha;
        this.capacidad = capacidad;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
}