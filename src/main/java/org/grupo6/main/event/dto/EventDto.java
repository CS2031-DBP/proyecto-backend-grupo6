package org.grupo6.main.event.dto;

import org.grupo6.main.restaurant.domain.Restaurant;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.Date;

public class EventDto {
    private Long id;
    private String nombre;
    private LocalDateTime fecha;
    private Long restaurantId;


    //
    private int capacidad;
    private Restaurant restaurant;

    // Getters y setters

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }


    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Restaurant getRestaurant() {return restaurant;
    }

    public int getCapacidad() {return capacidad;
    }
    public void setCapacidad(int capacidad) {this.capacidad = capacidad;
    }
    public void setRestaurant(Restaurant restaurant) {this.restaurant = restaurant;}


    public LocalDateTime getFecha() {return fecha;
    }
}
