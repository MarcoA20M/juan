// src/main/java/com/repositorio/repositorioWeb/dto/LoginResponse.java
package com.repositorio.repositorioWeb.dto;

public class LoginResponse {
    private String token;
    private String email;
    private String role;

    public LoginResponse(String token, String email, String role) {
        this.token = token;
        this.email = email;
        this.role = role;
    }

    // Getters
    public String getToken() {
        return token;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }
}
