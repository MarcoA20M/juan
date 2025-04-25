package com.repositorio.repositorioWeb.repository;

import com.repositorio.repositorioWeb.model.LearningMaterial;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LearningMaterialRepository extends JpaRepository<LearningMaterial, Long> {
   // List<LearningMaterial> findByAssignmentId(Long idAssignment); // Buscar materiales por ID de tarea
}