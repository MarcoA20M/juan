package com.repositorio.repositorioWeb.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "topics")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTopic; // Puedes cambiarlo a Integer si prefieres INT

    @ManyToOne
    @JoinColumn(name = "idCourse", nullable = false)
    private Course course;  // Relación con Course

    @Column(nullable = false)
    private String title;

    private String description;

    // Constructores
    public Topic() {}

    public Topic(Course course, String title, String description) {
        this.course = course;
        this.title = title;
        this.description = description;
    }

    // Getters y Setters
    public Long getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(Long idTopic) {
        this.idTopic = idTopic;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
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

    // Equals y HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topic topic = (Topic) o;
        return Objects.equals(idTopic, topic.idTopic) &&
               Objects.equals(course, topic.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTopic, course);
    }

    // ToString
    @Override
    public String toString() {
        return "Topic{" +
               "idTopic=" + idTopic +
               ", course=" + course +
               ", title='" + title + '\'' +
               ", description='" + description + '\'' +
               '}';
    }
}
