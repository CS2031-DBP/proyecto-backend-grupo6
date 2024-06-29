package org.grupo6.main.Usuario.DTO;


public class UsuarioDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String password;
    private String username;

    // Constructor vacío
    public UsuarioDTO() {
    }

    // Constructor con todos los parámetros
    public UsuarioDTO(Long id, String nombre, String email, String password, String username) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public UsuarioDTO(Object o, String nuevoUsuario, String mail) {
    }

    public UsuarioDTO(long l, String usuarioActualizado, String mail, String pass, String userupdate) {
    }


    // Getters
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}