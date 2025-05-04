package com.repositorio.repositorioWeb.service;

import com.repositorio.repositorioWeb.config.JwtService;
import com.repositorio.repositorioWeb.dto.AuthResponse;
import com.repositorio.repositorioWeb.dto.LoginRequest;
import com.repositorio.repositorioWeb.dto.RegisterRequest;
import com.repositorio.repositorioWeb.model.*;
import com.repositorio.repositorioWeb.repository.*;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request) {
        // Verificar si el email ya está registrado
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new IllegalArgumentException("El correo electrónico ya está registrado");
        }

        // Crear nuevo usuario
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setMaternalLastName(request.getMaternalLastName());
        user.setEmail(request.getEmail());
        user.setPasswordHash(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());

        // Guardar el usuario
        User savedUser = userRepository.save(user);

        // Crear entidad según el rol
        if (user.getRole() == Role.STUDENT) {
            Student student = new Student();
            student.setUser(savedUser);
            student.setDateOfBirth(request.getDateOfBirth());  // Agrega estos campos a RegisterRequest
            student.setGradeLevel(request.getGradeLevel());
            studentRepository.save(student);
        } else if (user.getRole() == Role.TEACHER) {
            Teacher teacher = new Teacher();
            teacher.setUser(savedUser);
            teacher.setSpecialization(request.getSpecialty());
            teacherRepository.save(teacher);
        }

        // Generar token JWT
        String jwtToken = jwtService.generateToken(savedUser);

        return new AuthResponse(jwtToken, savedUser.getEmail(), savedUser.getRole().name());
    }

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
            )
        );

        User user = userRepository.findByEmail(request.getEmail())
            .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        String jwtToken = jwtService.generateToken(user);

        return new AuthResponse(jwtToken, user.getEmail(), user.getRole().name());
    }
}
