package com.example.sena.configuration.exception;

import jakarta.persistence.EntityNotFoundException;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public class CodigoNotFoundException extends EntityNotFoundException {

    private String message;

    public CodigoNotFoundException(String message){
        super(message);
        this.message = message;
    }
    
}
