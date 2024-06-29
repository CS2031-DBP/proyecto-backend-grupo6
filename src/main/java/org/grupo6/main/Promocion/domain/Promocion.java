package org.grupo6.main.Promocion.domain;

import jakarta.persistence.*;
import org.grupo6.main.Restaurante.domain.Restaurante;
import org.grupo6.main.Usuario.Domain.Usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Promocion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFin;

    @ManyToMany(mappedBy = "promociones")
    private List<Restaurante> restaurantes = new ArrayList<>();

    @ManyToMany(mappedBy = "promociones")
    private List<Usuario> usuarios = new ArrayList<>();

    // Constructor sin argumentos que inicializa las listas
    public Promocion() {
        this.restaurantes = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    // Constructor con argumentos
    public Promocion(Long id, String descripcion, Date fechaInicio, Date fechaFin,
                     List<Restaurante> restaurantes, List<Usuario> usuarios) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.restaurantes = restaurantes != null ? restaurantes : new ArrayList<>();
        this.usuarios = usuarios != null ? usuarios : new ArrayList<>();
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public List<Restaurante> getRestaurantes() {
        return restaurantes;
    }

    public void setRestaurantes(List<Restaurante> restaurantes) {
        this.restaurantes = restaurantes;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}