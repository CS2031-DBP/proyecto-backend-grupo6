package org.grupo6.main.Ubicacion.DTO;

public class UbicacionDTO {
    private Long id;
    private String direccion;
    private String ciudad;
    private String pais;

    public UbicacionDTO() {
    }

    // Constructor con argumentos
    public UbicacionDTO(Long id, String direccion, String ciudad, String pais) {
        this.id = id;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.pais = pais;
    }
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