package com.azevedo.userpost.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(System.currentTimeMillis(),
                status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardError> handleException(Exception e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        StandardError err = new StandardError(System.currentTimeMillis(),
                status.value(), "Erro interno do servidor", e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }
}
