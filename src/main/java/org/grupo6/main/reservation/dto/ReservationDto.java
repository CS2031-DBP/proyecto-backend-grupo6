package org.grupo6.main.reservation.dto;

import org.grupo6.main.restaurant.domain.Restaurant;
import org.grupo6.main.user.domain.User;

import java.time.LocalDateTime;
import java.util.Date;

public class ReservationDto {
    private Long id;
    private Long userId;
    private Long restaurantId;
    private Date fecha;
    private String estado;


    //
    Restaurant restaurant;
    User user;
    LocalDateTime fechaInicio;
    // Getters y setters




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }









    public User getUser() {
        return user;
    }

    public Restaurant getRestaurant() {return restaurant;
    }


    public void setUser(User user) {this.user = user;
    }

    public void setRestaurant(Restaurant restaurant) {this.restaurant = restaurant;
    }

    public void setFechaHora(LocalDateTime fechaHora) {this.fechaInicio = fechaHora;
    }

    public LocalDateTime getFechaHora() {return fechaInicio;
    }
}
