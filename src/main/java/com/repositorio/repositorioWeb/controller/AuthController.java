package com.repositorio.repositorioWeb.controller;

import com.repositorio.repositorioWeb.dto.LoginRequest;
import com.repositorio.repositorioWeb.dto.LoginResponse;
import com.repositorio.repositorioWeb.model.User;
import com.repositorio.repositorioWeb.service.JwtService;
import com.repositorio.repositorioWeb.service.UserService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")  // Permitir solicitudes desde el frontend
public class AuthController {

    private final UserService userService;
    private final JwtService jwtService;

    @Autowired
    public AuthController(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest request) {
        Optional<User> optionalUser = userService.authenticateUser(request.getEmail(), request.getPassword());
    
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            String token = jwtService.generateToken(user);
            LoginResponse response = new LoginResponse(token, user.getEmail(), user.getRole().name());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
    }
}
