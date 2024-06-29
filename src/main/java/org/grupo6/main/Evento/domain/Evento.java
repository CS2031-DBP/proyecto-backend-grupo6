package org.grupo6.main.Evento.domain;

import jakarta.persistence.*;
import org.grupo6.main.Evento.DTO.EventoDTO;
import org.grupo6.main.Restaurante.domain.Restaurante;

import java.util.Date;

@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante;

    private String nombre;
    private Date fecha;
    private int capacidad;

    public Evento(Long l, Restaurante restaurante, String s, Object o, int i) {
    }
    public Evento(){

    }
    public Evento(Long id, Restaurante restaurante, String nombre, Date fecha, int capacidad) {
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