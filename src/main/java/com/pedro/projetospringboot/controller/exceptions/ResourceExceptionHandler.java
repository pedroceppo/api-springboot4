package com.pedro.projetospringboot.controller.exceptions;

import com.pedro.projetospringboot.services.exceptions.DatabaseException;
import com.pedro.projetospringboot.services.exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class ResourceExceptionHandler  {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String,String>> resourceNotFound(ResourceNotFoundException ex){
        Map<String,String>body = Map.of("message",ex.getMessage());

        return ResponseEntity.status(404).body(body);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<Map<String,String>>body(DatabaseException ex){
        Map<String,String>body = Map.of("message",ex.getMessage());
        return ResponseEntity.status(409).body(body);
    }

}
