package com.repositorio.repositorioWeb.repository;

import com.repositorio.repositorioWeb.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
   // List<Course> findByTeacherId(Long idTeacher); // Buscar cursos por ID de profesor
}