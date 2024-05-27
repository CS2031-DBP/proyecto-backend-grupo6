package org.grupo6.main.restaurant.dto;

import lombok.Getter;
import lombok.Setter;
import org.grupo6.main.location.domain.Location;

public class RestaurantDto {
    @Setter
    @Getter
    private Long id;
    @Setter
    @Getter
    private String nombre;
    @Setter
    @Getter
    private Long locationId;
    private Location location;
    // Getters y setters

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
    }
}
