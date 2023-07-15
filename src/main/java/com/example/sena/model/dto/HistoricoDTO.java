/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sena.model.dto;

import com.example.sena.model.entity.Usuario;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotEmpty;
import java.math.BigInteger;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author LENOVO
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"id","llaveId","instructorId", "funcionarioId","fechaHoraPrestamo","fechaHoraDevolucion"})
public class HistoricoDTO {
    @JsonProperty("id")
    @JsonAlias("idHistorico")
    private Integer id;
    @NotEmpty
    @JsonProperty( value = "llave_id", required = true)
    private BigInteger llaveId;
    @NotEmpty
    @JsonProperty( value = "instructor_id", required = true)
    private BigInteger instructorId;
    @NotEmpty
    @JsonProperty( value = "funcionario", required = true)
    private BigInteger funcionarioId;
    @JsonProperty( value = "fechaHoraPrestamo", required = false)
    private Date fechaHoraPrestamo;
    @JsonProperty( value = "fechaHoraDevolucion", required = false)
    private Date fechaHoraDevolucion;
}
