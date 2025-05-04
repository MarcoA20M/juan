package com.repositorio.repositorioWeb.repository;

import com.repositorio.repositorioWeb.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    // Búsqueda por nombre o descripción (ignorando mayúsculas/minúsculas)
    @Query("SELECT c FROM Course c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           "LOWER(c.description) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Course> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(@Param("query") String query);
    
    // También puedes usar el nombre derivado del método (sin @Query)
    // List<Course> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String nameQuery, String descriptionQuery);
}