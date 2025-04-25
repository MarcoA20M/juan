package com.repositorio.repositorioWeb.model;

import jakarta.persistence.*;
import java.util.Objects;
import java.util.Date;

@Entity
@Table(name = "assignments")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAssignment; // Puedes cambiarlo a Integer si prefieres INT

    @ManyToOne
    @JoinColumn(name = "idTopic", nullable = false)
    private Topic topic;  // Relación con Topic

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(nullable = false)
    private Date dueDate;  // Fecha de entrega

    // Constructores
    public Assignment() {}

    public Assignment(Topic topic, String title, String description, Date dueDate) {
        this.topic = topic;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
    }

    // Getters y Setters
    public Long getIdAssignment() {
        return idAssignment;
    }

    public void setIdAssignment(Long idAssignment) {
        this.idAssignment = idAssignment;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    // Equals y HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assignment that = (Assignment) o;
        return Objects.equals(idAssignment, that.idAssignment) &&
               Objects.equals(topic, that.topic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAssignment, topic);
    }

    // ToString
    @Override
    public String toString() {
        return "Assignment{" +
               "idAssignment=" + idAssignment +
               ", topic=" + topic +
               ", title='" + title + '\'' +
               ", description='" + description + '\'' +
               ", dueDate=" + dueDate +
               '}';
    }
}
