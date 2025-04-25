package com.repositorio.repositorioWeb.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.repositorio.repositorioWeb.model.User;



public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}