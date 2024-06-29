package org.grupo6.main.Reseña.DTO;

import org.grupo6.main.Restaurante.domain.Restaurante;
import org.grupo6.main.Usuario.Domain.Usuario;

public class ReseñaDTO {
    private Long id;
    private Usuario usuario;
    private Restaurante restaurante;
    private int valoracion;
    private String comentario;

    public ReseñaDTO(Long id, Usuario usuario, Restaurante restaurante, int valoracion, String comentario) {
        this.id = id;
        this.usuario = usuario;
        this.restaurante = restaurante;
        this.valoracion = valoracion;
        this.comentario = comentario;
    }

    public ReseñaDTO(){

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

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}