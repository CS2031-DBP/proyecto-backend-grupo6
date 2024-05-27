package org.grupo6.main.location.dto;

public class LocationDto {
    private Long id;
    private String direccion;
    private String ciudad;
    private String pais;

    // Getters y setters

    public Long getId() {
        return id;
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
