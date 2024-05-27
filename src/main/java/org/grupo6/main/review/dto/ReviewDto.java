package org.grupo6.main.review.dto;

import org.grupo6.main.restaurant.domain.Restaurant;
import org.grupo6.main.user.domain.User;

public class ReviewDto {
    private Long id;
    private Long userId;
    private Long restaurantId;
    private String comentario;



    private int puntuacion;
    private User user;
    private int valoracion;
    private Restaurant restaurant;


    // Getters y setters

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public String getComentario() {
        return comentario;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }




    public int getValoracion() {
        return valoracion;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRestaurant(Restaurant restaurant) {this.restaurant = restaurant;
    }

    public void setValoracion(int valoracion) {this.valoracion = valoracion;
    }
}
