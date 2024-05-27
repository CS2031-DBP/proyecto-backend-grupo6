package org.grupo6.main.exceptions;

public class RestaurantNotFoundException extends CustomException {
    public RestaurantNotFoundException(String message) {
        super(message);
    }
}