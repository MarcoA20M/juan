package com.repositorio.repositorioWeb.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "submissions")
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSubmission;

    @ManyToOne
    @JoinColumn(name = "idAssignment", nullable = false)
    private Assignment assignment;  // Relación con Assignment (Tarea)

    @ManyToOne
    @JoinColumn(name = "idStudent", nullable = false)
    private Student student;  // Relación con Student (Estudiante)

    @Column(nullable = false)
    private Date submissionDate;  // Fecha de la entrega

    @Column(nullable = false)
    private String fileUrl;  // Ruta o URL del archivo entregado

    // Constructores
    public Submission() {}

    public Submission(Assignment assignment, Student student, Date submissionDate, String fileUrl) {
        this.assignment = assignment;
        this.student = student;
        this.submissionDate = submissionDate;
        this.fileUrl = fileUrl;
    }

    // Getters y Setters
    public Long getIdSubmission() {
        return idSubmission;
    }

    public void setIdSubmission(Long idSubmission) {
        this.idSubmission = idSubmission;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    // Equals y HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Submission that = (Submission) o;
        return Objects.equals(idSubmission, that.idSubmission) &&
               Objects.equals(assignment, that.assignment) &&
               Objects.equals(student, that.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSubmission, assignment, student);
    }

    // ToString
    @Override
    public String toString() {
        return "Submission{" +
               "idSubmission=" + idSubmission +
               ", assignment=" + assignment +
               ", student=" + student +
               ", submissionDate=" + submissionDate +
               ", fileUrl='" + fileUrl + '\'' +
               '}';
    }
}
