package com.repositorio.repositorioWeb.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStudent;

    @OneToOne
    @JoinColumn(name = "idUser", nullable = false, unique = true)
    private User user;

    private String dateOfBirth;
    private String gradeLevel;

    // Relación con la tabla intermedia StudentCourse
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StudentCourse> studentCourses;

    // Constructores
    public Student() {}

    public Student(User user, String dateOfBirth, String gradeLevel, List<StudentCourse> studentCourses) {
        this.user = user;
        this.dateOfBirth = dateOfBirth;
        this.gradeLevel = gradeLevel;
        this.studentCourses = studentCourses;
    }

    // Getters y Setters
    public Long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Long idStudent) {
        this.idStudent = idStudent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
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
        Student student = (Student) o;
        return Objects.equals(idStudent, student.idStudent) &&
               Objects.equals(user, student.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStudent, user);
    }

    // ToString
    @Override
    public String toString() {
        return "Student{" +
               "idStudent=" + idStudent +
               ", user=" + user +
               ", dateOfBirth='" + dateOfBirth + '\'' +
               ", gradeLevel='" + gradeLevel + '\'' +
               ", studentCourses=" + studentCourses +
               '}';
    }
}
