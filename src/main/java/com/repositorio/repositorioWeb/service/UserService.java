package com.repositorio.repositorioWeb.service;
import com.repositorio.repositorioWeb.model.User;
import com.repositorio.repositorioWeb.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long idUser) {
        return userRepository.findById(idUser)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + idUser));
    }

    public User createUser(User user) {
        // Encriptar la contraseña antes de guardar
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
        return userRepository.save(user);
    }

    public User updateUser(Long idUser, User updatedUser) {
        User user = getUserById(idUser);
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setMaternalLastName(updatedUser.getMaternalLastName());
        user.setEmail(updatedUser.getEmail());
        user.setRole(updatedUser.getRole());

        if (updatedUser.getPasswordHash() != null && !updatedUser.getPasswordHash().isBlank()) {
            user.setPasswordHash(passwordEncoder.encode(updatedUser.getPasswordHash()));
        }

        return userRepository.save(user);
    }

    public void deleteUser(Long idUser) {
        if (!userRepository.existsById(idUser)) {
            throw new EntityNotFoundException("User not found with id: " + idUser);
        }
        userRepository.deleteById(idUser);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public Optional<User> authenticateUser(String email, String password) {
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isPresent() && passwordEncoder.matches(password, userOpt.get().getPasswordHash())) {
            return userOpt;
        }
        return Optional.empty();
    }
    
}
