package org.grupo6.main.promotion.domain;

import jakarta.persistence.*;
import org.grupo6.main.restaurant.domain.Restaurant;
import org.grupo6.main.user.domain.User;

import java.util.Date;
import java.util.List;

@Entity

public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private double descuento;

    @ManyToMany(mappedBy = "promotiones")
    private List<User> users;

    @ManyToMany(mappedBy = "promotiones")
    private List<Restaurant> restaurants;


    //
    private Restaurant restaurant;
    private Date fechaInicio;
    private Date fechaFin;
    // Getters and Setters

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

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }


    public void setRestaurant(Restaurant restaurant) {this.restaurant = restaurant
            ;
    }

    public void setFechaInicio(Date fechaInicio) {this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {this.fechaFin = fechaFin;
    }

    public Restaurant getRestaurant() {return restaurant;
    }

    public Date getFechaFin() {return fechaFin;
    }

    public Date getFechaInicio() {return fechaInicio;
    }


}
