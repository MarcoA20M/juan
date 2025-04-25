package com.repositorio.repositorioWeb.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.repositorio.repositorioWeb.model.Student;
import com.repositorio.repositorioWeb.model.User;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // Puedes agregar métodos personalizados aquí si es necesario
    boolean existsByUser(User user);
}