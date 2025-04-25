package com.repositorio.repositorioWeb.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        // Aquí puedes crear un mensaje más claro basado en la excepción
        String errorMessage = "Error: El correo electrónico ya está registrado.";

        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
