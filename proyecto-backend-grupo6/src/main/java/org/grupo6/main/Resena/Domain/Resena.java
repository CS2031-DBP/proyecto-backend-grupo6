package org.grupo6.main.Resena.Domain;

import jakarta.persistence.*;
import org.grupo6.main.Reserva.Domain.Reserva;
import org.grupo6.main.Usuario.Domain.Usuario;

import javax.persistence.*;

@Entity
public class Resena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;

    private String comentario;
    private int valoracion;

    public Resena() {
    }

    public Resena(Usuario usuario, Reserva reserva, String comentario, int valoracion) {
        this.usuario = usuario;
        this.reserva = reserva;
        this.comentario = comentario;
        this.valoracion = valoracion;
    }

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

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }
}