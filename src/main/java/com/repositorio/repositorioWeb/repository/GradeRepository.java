package com.repositorio.repositorioWeb.repository;

import com.repositorio.repositorioWeb.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface GradeRepository extends JpaRepository<Grade, Long> {
    ///Optional<Grade> findBySubmissionId(Long idSubmission); // Buscar calificación por ID de entrega
}