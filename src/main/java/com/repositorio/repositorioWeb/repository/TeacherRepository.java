package com.repositorio.repositorioWeb.repository;



import com.repositorio.repositorioWeb.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    // Puedes agregar métodos personalizados aquí si es necesario
}