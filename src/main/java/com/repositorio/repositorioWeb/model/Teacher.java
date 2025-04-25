package com.repositorio.repositorioWeb.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTeacher;

    @OneToOne
    @JoinColumn(name = "idUser", nullable = false, unique = true)
    private User user;

    private String specialization;

    // Constructores
    public Teacher() {}

    public Teacher(User user, String specialization) {
        this.user = user;
        this.specialization = specialization;
    }

    // Getters y Setters
    public Long getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(Long idTeacher) {
        this.idTeacher = idTeacher;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    // Equals y HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(idTeacher, teacher.idTeacher) &&
               Objects.equals(user, teacher.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTeacher, user);
    }

    // ToString
    @Override
    public String toString() {
        return "Teacher{" +
               "idTeacher=" + idTeacher +
               ", user=" + user +
               ", specialization='" + specialization + '\'' +
               '}';
    }
}
