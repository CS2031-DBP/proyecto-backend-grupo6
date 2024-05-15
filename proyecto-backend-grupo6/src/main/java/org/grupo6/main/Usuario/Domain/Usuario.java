package org.grupo6.main.Usuario.Domain;

import jakarta.persistence.*;

import javax.persistence.*;
import java.util.List;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private String telefono;
    private String roles; // Para Spring Security

    // Relaciones
    @OneToMany(mappedBy = "usuario")
    private List<Reserva> reservas;

    @OneToMany(mappedBy = "usuario")
    private List<Reseña> reseñas;

    // Getters y Setters
    // hashCode(), equals() y toString() si son necesarios
}
