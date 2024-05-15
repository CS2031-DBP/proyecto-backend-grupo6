package org.grupo6.main.Reserva.DTO;

import java.time.LocalDateTime;

public class ReservaDTO {

    private Long id;
    private LocalDateTime fecha;
    private String metodoPago;

    // Constructor
    public ReservaDTO() {
    }

    // Constructor con todos los campos
    public ReservaDTO(Long id, LocalDateTime fecha, String metodoPago) {
        this.id = id;
        this.fecha = fecha;
        this.metodoPago = metodoPago;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
}