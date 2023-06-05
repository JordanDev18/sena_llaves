package com.example.sena.model.dto;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonPropertyOrder({"id", "nombre", "apellido", "email", "telefono", "enabled","estado"})
public class UsuarioDTO {

    private UUID id;

    private String nombre;

    private String apellido;
    
    private String email;
    
    private String telefono;

    @JsonIgnore
    private String password;

    @JsonIgnore
	private String authority;

    private Boolean enabled;


    private Boolean estado;
    
}
