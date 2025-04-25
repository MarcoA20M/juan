package com.repositorio.repositorioWeb.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.repositorio.repositorioWeb.model.User;
import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")  // Permite todos los orígenes y encabezados
public class LoginController {

    @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        // Lógica de autenticación aquí
        return ResponseEntity.ok("Login successful");
    }
}
