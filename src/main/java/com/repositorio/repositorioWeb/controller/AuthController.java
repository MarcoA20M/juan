package com.repositorio.repositorioWeb.controller;

import com.repositorio.repositorioWeb.dto.*;
import com.repositorio.repositorioWeb.model.User;
import com.repositorio.repositorioWeb.repository.UserRepository;
import com.repositorio.repositorioWeb.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final UserRepository userRepository; 

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    

    // @PutMapping("/profile")
    // public ResponseEntity<UserProfileResponse> updateUserProfile(
    //         @RequestBody UpdateProfileRequest request,
    //         Authentication authentication
    // ) {
    //     return ResponseEntity.ok(authService.updateUserProfile(request, authentication));
    // }

    @GetMapping("/profile")
public ResponseEntity<UserProfileResponse> getUserProfile(Authentication authentication) {
    String email = authentication.getName();
    User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
    
    UserProfileResponse response = new UserProfileResponse();
    response.setFirstName(user.getFirstName());
    response.setLastName(user.getLastName());
    response.setMaternalLastName(user.getMaternalLastName());
    response.setEmail(user.getEmail());
    response.setRole(user.getRole());
   // response.setGrade(user.getGra()); // Campo adicional si lo necesitas
    
    return ResponseEntity.ok(response);
}
}