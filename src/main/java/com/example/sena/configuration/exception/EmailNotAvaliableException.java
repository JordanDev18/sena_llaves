package com.example.sena.configuration.exception;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public class EmailNotAvaliableException extends IllegalStateException {

    private String message;

    public EmailNotAvaliableException(String message){
        super(message);
        this.message = message;
    }

}
