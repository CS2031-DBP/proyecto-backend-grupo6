package org.grupo6.main.location.domain;

import jakarta.persistence.*;
import org.grupo6.main.restaurant.domain.Restaurant;

import java.util.List;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String direccion;
    private String ciudad;
    private String pais;

    @OneToMany(mappedBy = "ubicacion")
    private List<Restaurant> restaurantes;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public List<Restaurant> getRestaurantes() {
        return restaurantes;
    }

    public void setRestaurantes(List<Restaurant> restaurantes) {
        this.restaurantes = restaurantes;
    }
}
