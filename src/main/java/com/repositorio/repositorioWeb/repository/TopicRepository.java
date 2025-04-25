package com.repositorio.repositorioWeb.repository;

import com.repositorio.repositorioWeb.model.Topic;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    // Aquí puedes añadir métodos personalizados si es necesario, por ejemplo:
    //List<Topic> findByCourseId(Long courseId);
}
