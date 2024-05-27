package org.grupo6.main.auth.DTO;

public class LoginReq {
    private String username;
    private String password;

    // Getters y Setters


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}