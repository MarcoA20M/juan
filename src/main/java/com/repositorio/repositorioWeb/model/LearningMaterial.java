package com.repositorio.repositorioWeb.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "learningMaterials")
public class LearningMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMaterial; // Puedes cambiarlo a Integer si prefieres INT

    @ManyToOne
    @JoinColumn(name = "idTopic", nullable = false)
    private Topic topic;  // Relación con Topic

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String fileUrl;

    // Constructores
    public LearningMaterial() {}

    public LearningMaterial(Topic topic, String name, String fileUrl) {
        this.topic = topic;
        this.name = name;
        this.fileUrl = fileUrl;
    }

    // Getters y Setters
    public Long getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Long idMaterial) {
        this.idMaterial = idMaterial;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        LearningMaterial that = (LearningMaterial) o;
        return Objects.equals(idMaterial, that.idMaterial) &&
               Objects.equals(topic, that.topic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMaterial, topic);
    }

    // ToString
    @Override
    public String toString() {
        return "LearningMaterial{" +
               "idMaterial=" + idMaterial +
               ", topic=" + topic +
               ", name='" + name + '\'' +
               ", fileUrl='" + fileUrl + '\'' +
               '}';
    }
}
