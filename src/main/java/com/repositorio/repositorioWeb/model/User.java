package com.repositorio.repositorioWeb.model;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User implements UserDetails {
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
    private Role role;

    // Constructores
    public User() {
    }

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

    // UserDetails methods
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return passwordHash;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
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