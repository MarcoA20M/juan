package com.repositorio.repositorioWeb.model;

import java.util.Objects;

import jakarta.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column(nullable = false)
    @NotBlank(message = "El nombre no puede estar vacío.")
    @NotNull(message = "El nombre no puede ser nulo.")
    private String firstName;

    @Column(nullable = false)
    @NotBlank(message = "El apellido paterno no puede estar vacío.")
    @NotNull(message = "El apellido paterno no puede ser nulo.")
    private String lastName;

    @Column(nullable = false)
    @NotBlank(message = "El apellido materno no puede estar vacío.")
    @NotNull(message = "El apellido materno no puede ser nulo.")
    private String maternalLastName;

    @Column(nullable = false, unique = true)
    @Email(message = "El correo electrónico debe ser válido.")
    @NotBlank(message = "El correo electrónico no puede estar vacío.")
    @NotNull(message = "El correo electrónico no puede ser nulo.")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "La contraseña no puede estar vacía.")
    @NotNull(message = "La contraseña no puede ser nula.")
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull(message = "El rol no puede ser nulo.")
    private Role role; // Enum: STUDENT, TEACHER

    // Constructores
    public User() {}

    public User(String firstName, String lastName, String maternalLastName, String email, String passwordHash, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.maternalLastName = maternalLastName;
        this.email = email;
        this.passwordHash = passwordHash;
        this.role = role;
    }

    // Getters y Setters
    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMaternalLastName() {
        return maternalLastName;
    }

    public void setMaternalLastName(String maternalLastName) {
        this.maternalLastName = maternalLastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    // Equals y HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(idUser, user.idUser) &&
               Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, email);
    }

    // ToString
    @Override
    public String toString() {
        return "User{" +
               "idUser=" + idUser +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", maternalLastName='" + maternalLastName + '\'' +
               ", email='" + email + '\'' +
               ", role=" + role +
               '}';
    }

   
}
