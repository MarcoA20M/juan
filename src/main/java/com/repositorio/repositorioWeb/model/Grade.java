package com.repositorio.repositorioWeb.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "grades")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGrade;

    @ManyToOne
    @JoinColumn(name = "idSubmission", nullable = false)
    private Submission submission;  // Relación con Submission (Entrega)

    private BigDecimal score;  // Calificación (0-10)

    private String feedback;  // Comentarios del maestro

    // Constructores
    public Grade() {}

    public Grade(Submission submission, BigDecimal score, String feedback) {
        this.submission = submission;
        this.score = score;
        this.feedback = feedback;
    }

    // Getters y Setters
    public Long getIdGrade() {
        return idGrade;
    }

    public void setIdGrade(Long idGrade) {
        this.idGrade = idGrade;
    }

    public Submission getSubmission() {
        return submission;
    }

    public void setSubmission(Submission submission) {
        this.submission = submission;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    // Equals y HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade grade = (Grade) o;
        return Objects.equals(idGrade, grade.idGrade) &&
               Objects.equals(submission, grade.submission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGrade, submission);
    }

    // ToString
    @Override
    public String toString() {
        return "Grade{" +
               "idGrade=" + idGrade +
               ", submission=" + submission +
               ", score=" + score +
               ", feedback='" + feedback + '\'' +
               '}';
    }
}
