package org.grupo6.main.Reserva.DTO;

import org.grupo6.main.Restaurante.domain.Restaurante;
import org.grupo6.main.Usuario.Domain.Usuario;

import java.time.LocalDateTime;

public class ReservaDTO {
    private Long id;
    private Usuario usuario;
    private Restaurante restaurante;
    private LocalDateTime fechaHora;
    private String estado;

    public ReservaDTO(Long id, Usuario usuario, Restaurante restaurante, LocalDateTime fechaHora, String confirmada) {
    }
    public ReservaDTO(){

    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}