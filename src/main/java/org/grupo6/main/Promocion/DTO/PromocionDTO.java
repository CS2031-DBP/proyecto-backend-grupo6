package org.grupo6.main.Promocion.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PromocionDTO {
    private Long id;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFin;
    private List<Long> restauranteIds;
    private List<Long> usuarioIds;

    // Constructor sin argumentos
    public PromocionDTO() {}

    // Constructor con argumentos
    public PromocionDTO(String descripcion, Date fechaInicio, Date fechaFin, List<Long> restauranteIds, List<Long> usuarioIds) {
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.restauranteIds = restauranteIds;
        this.usuarioIds = usuarioIds;
    }

    public <E> PromocionDTO(Object o, String nuevaPromoción, Object o1, Object o2, ArrayList<E> es, ArrayList<E> es1) {
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

    public List<Long> getRestauranteIds() {
        return restauranteIds;
    }

    public void setRestauranteIds(List<Long> restauranteIds) {
        this.restauranteIds = restauranteIds;
    }

    public List<Long> getUsuarioIds() {
        return usuarioIds;
    }

    public void setUsuarioIds(List<Long> usuarioIds) {
        this.usuarioIds = usuarioIds;
    }
}