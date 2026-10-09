package com.pedro.projetospringboot.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Long id) {
        super("Usuário não encontrado com o id: " + id);
    }
}
