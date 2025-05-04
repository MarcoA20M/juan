package com.repositorio.repositorioWeb.dto;

import java.util.Objects;

public class AuthResponse {
    private String token;
    private String email;
    private String role;

    // Constructores
    public AuthResponse() {
    }

    public AuthResponse(String token, String email, String role) {
        this.token = token;
        this.email = email;
        this.role = role;
    }

    // Builder
    public static AuthResponseBuilder builder() {
        return new AuthResponseBuilder();
    }

    // Getters y Setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Equals y HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthResponse that = (AuthResponse) o;
        return Objects.equals(token, that.token) &&
               Objects.equals(email, that.email) &&
               Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, email, role);
    }

    // ToString
    @Override
    public String toString() {
        return "AuthResponse{" +
               "token='" + token + '\'' +
               ", email='" + email + '\'' +
               ", role='" + role + '\'' +
               '}';
    }

    // Builder Class
    public static class AuthResponseBuilder {
        private String token;
        private String email;
        private String role;

        AuthResponseBuilder() {
        }

        public AuthResponseBuilder token(String token) {
            this.token = token;
            return this;
        }

        public AuthResponseBuilder email(String email) {
            this.email = email;
            return this;
        }

        public AuthResponseBuilder role(String role) {
            this.role = role;
            return this;
        }

        public AuthResponse build() {
            return new AuthResponse(this.token, this.email, this.role);
        }

        @Override
        public String toString() {
            return "AuthResponse.AuthResponseBuilder{" +
                   "token='" + token + '\'' +
                   ", email='" + email + '\'' +
                   ", role='" + role + '\'' +
                   '}';
        }
    }
}