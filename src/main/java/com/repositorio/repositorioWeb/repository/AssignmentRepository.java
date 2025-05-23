package com.repositorio.repositorioWeb.repository;

import com.repositorio.repositorioWeb.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    //List<Assignment> findByCourseId(Long idCourse); // Buscar tareas por ID de curso
}