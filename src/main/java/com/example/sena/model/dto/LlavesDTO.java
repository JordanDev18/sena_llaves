package com.example.sena.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"id", "codigo", "nombre", "cantidad",  "fechaCreacion", "ultimaActualizacion"})
public class LlavesDTO {

    @JsonProperty("id")
    @JsonAlias("idLlaves")
    private UUID id;

    @JsonProperty( value = "codigo", required = false)
    private String codigo;

    @NotEmpty
    @JsonProperty( value = "nombre", required = true)
    private String nombre;

    @NotEmpty
    @JsonProperty( value = "cantidad", required = true)
    private BigDecimal cantidad;

    @NotEmpty
    @JsonProperty( value = "disponible", required = true)
    private Boolean disponible;

    @JsonProperty( value = "fechaCreacion", required = false)
    private LocalDateTime fechaCreacion;

    @JsonProperty(value = "ultimaActualizacion", required = false)
    private LocalDateTime ultimaActualizacion;
    
}
