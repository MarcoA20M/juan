package com.repositorio.repositorioWeb.dto;



import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LoginRequest {
    @Email(message = "El correo electrónico debe ser válido.")
    @NotBlank(message = "El correo electrónico no puede estar vacío.")
    @NotNull(message = "El correo electrónico no puede ser nulo.")
    private String email;

    @NotBlank(message = "La contraseña no puede estar vacía.")
    @NotNull(message = "La contraseña no puede ser nula.")
    private String password;

    // Constructores
    public LoginRequest() {
    }

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters y Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Equals y HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginRequest that = (LoginRequest) o;
        return Objects.equals(email, that.email) && 
               Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password);
    }

    // ToString
    @Override
    public String toString() {
        return "LoginRequest{" +
               "email='" + email + '\'' +
               ", password='[PROTECTED]'" +
               '}';
    }

    // Builder Pattern
    public static LoginRequestBuilder builder() {
        return new LoginRequestBuilder();
    }

    public static class LoginRequestBuilder {
        private String email;
        private String password;

        LoginRequestBuilder() {
        }

        public LoginRequestBuilder email(String email) {
            this.email = email;
            return this;
        }

        public LoginRequestBuilder password(String password) {
            this.password = password;
            return this;
        }

        public LoginRequest build() {
            return new LoginRequest(this.email, this.password);
        }

        @Override
        public String toString() {
            return "LoginRequest.LoginRequestBuilder{" +
                   "email='" + email + '\'' +
                   ", password='[PROTECTED]'" +
                   '}';
        }
    }
}