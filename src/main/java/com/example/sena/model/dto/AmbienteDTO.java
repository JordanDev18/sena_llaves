package com.example.sena.model.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Date;
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
@JsonPropertyOrder({"id","floor","nombre","fechaCreacion", "ultimaActualizacion"})
public class AmbienteDTO {
    
    @JsonProperty("id")
    @JsonAlias("idFloor")
    private Integer id;

    @JsonProperty( value = "floor", required = false)
    private Integer floor;

    @NotEmpty
    @JsonProperty( value = "nombre", required = true)
    private String nombre;

    
    @JsonProperty( value = "fechaCreacion", required = false)
    private Date fechaCreacion;

    @JsonProperty(value = "ultimaActualizacion", required = false)
    private Date ultimaActualizacion;
}
