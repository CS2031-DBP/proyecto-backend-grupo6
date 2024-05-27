package org.grupo6.main.promotion.dto;

import org.grupo6.main.restaurant.domain.Restaurant;
import org.grupo6.main.restaurant.dto.RestaurantDto;

import java.util.Date;

public class PromotionDto {
    private Long id;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFin;
    private Long userId;
    private Long restaurantId;





    //
    Restaurant restaurant;
    // Getters y setters

    public Long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Restaurant getRestaurant() {return restaurant;
    }
}
