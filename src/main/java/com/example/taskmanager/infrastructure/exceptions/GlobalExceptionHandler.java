package com.example.taskmanager.infrastructure.exceptions;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

        @ExceptionHandler(ConstraintViolationException.class)
        public ResponseEntity<?> handleConstraintViolation(ConstraintViolationException exception) {
            Map<String, Object> response = new HashMap<>();
            response.put("status", HttpStatus.BAD_REQUEST.value());
            response.put("timestamp", LocalDateTime.now());
            response.put("mensagem", "Erro de violação de restrições");
            response.put("erros", exception.getConstraintViolations()
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.toList()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<?> handleValidation(MethodArgumentNotValidException exception) {
            Map<String, Object> response = new HashMap<>();
            response.put("status", HttpStatus.BAD_REQUEST.value());
            response.put("timestamp", LocalDateTime.now());
            response.put("mensagem", "Erro de validação do campo");
            response.put("erros", exception.getBindingResult()
                    .getFieldErrors()
                    .stream()
                    .map(error -> Map.of("campo", error.getField(), "mensagem", error.getDefaultMessage()))
                    .collect(Collectors.toList()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);

        }

        @ExceptionHandler(RuntimeException.class)
        public ResponseEntity<?> handleRuntime(RuntimeException exception) {
            Map<String, Object> response = new HashMap<>();
            response.put("status", HttpStatus.NOT_FOUND.value());
            response.put("timestamp", LocalDateTime.now());
            response.put("mensagem", "Recurso não encontrado");
            response.put("erro", exception.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

        }



}
