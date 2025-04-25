package com.repositorio.repositorioWeb.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCourse; // Puedes cambiarlo a Integer si prefieres INT

    @Column(nullable = false)
    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "idTeacher", nullable = false)
    private Teacher teacher;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Topic> topics;  // Relación con Topic (Tema)

    // Relación con la tabla intermedia StudentCourse
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StudentCourse> studentCourses;  // Relación con la tabla intermedia

    // Constructores
    public Course() {}

    public Course(String name, String description, Teacher teacher) {
        this.name = name;
        this.description = description;
        this.teacher = teacher;
    }

    // Getters y Setters
    public Long getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Long idCourse) {
        this.idCourse = idCourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public List<StudentCourse> getStudentCourses() {
        return studentCourses;
    }

    public void setStudentCourses(List<StudentCourse> studentCourses) {
        this.studentCourses = studentCourses;
    }

    // Equals y HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(idCourse, course.idCourse) &&
               Objects.equals(name, course.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCourse, name);
    }

    // ToString
    @Override
    public String toString() {
        return "Course{" +
               "idCourse=" + idCourse +
               ", name='" + name + '\'' +
               ", description='" + description + '\'' +
               ", teacher=" + teacher +
               ", topics=" + topics +
               ", studentCourses=" + studentCourses +
               '}';
    }
}
