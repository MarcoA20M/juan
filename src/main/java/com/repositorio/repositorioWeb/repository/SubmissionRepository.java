package com.repositorio.repositorioWeb.repository;

import com.repositorio.repositorioWeb.model.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {
   // List<Submission> findByAssignmentId(Long idAssignment); // Buscar entregas por ID de tarea
  //  List<Submission> findByStudentId(Long idStudent); // Buscar entregas por ID de estudiante
}