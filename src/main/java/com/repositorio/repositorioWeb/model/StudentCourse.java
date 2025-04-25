package com.repositorio.repositorioWeb.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "student_courses")
public class StudentCourse {

    @Id
    @ManyToOne
    @JoinColumn(name = "idStudent", nullable = false)
    private Student student;

    @Id
    @ManyToOne
    @JoinColumn(name = "idCourse", nullable = false)
    private Course course;

    // Constructores
    public StudentCourse() {}

    public StudentCourse(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    // Getters y Setters
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    // Equals y HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentCourse that = (StudentCourse) o;
        return Objects.equals(student, that.student) &&
               Objects.equals(course, that.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, course);
    }

    // ToString
    @Override
    public String toString() {
        return "StudentCourse{" +
               "student=" + student +
               ", course=" + course +
               '}';
    }
}
