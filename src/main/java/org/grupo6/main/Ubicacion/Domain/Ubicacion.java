package org.grupo6.main.Ubicacion.Domain;

import jakarta.persistence.*;
import org.grupo6.main.Restaurante.domain.Restaurante;

@Entity
public class Ubicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String direccion;
    private String ciudad;
    private String pais;

    @OneToOne(mappedBy = "ubicacion")
    private Restaurante restaurante;


    public Ubicacion(Long id, String direccion, String ciudad, String pais) {
        this.id = id;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.pais = pais;
    }

    public Ubicacion() {

    }

    // Getters y Setters

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

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }
}