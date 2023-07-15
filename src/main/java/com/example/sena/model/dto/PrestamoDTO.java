/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sena.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import java.math.BigInteger;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
/**
 *
 * @author LENOVO
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrestamoDTO {
    @JsonProperty("id")
    @JsonAlias("idPrestamo")
    private Integer id;
    @NotEmpty
    @JsonProperty( value = "llave_id", required = true)
    private BigInteger llaveId;
    @NotEmpty
    @JsonProperty( value = "instructor_id", required = true)
    private BigInteger instructorId;
    @NotEmpty
    @JsonProperty( value = "funcionario_id", required = true)
    private BigInteger funcionarioId;
    @JsonProperty( value = "fechaHoraPrestamo", required = false)
    private Date fechaHoraPrestamo;
    @JsonProperty( value = "fechaHoraDevolucion", required = false)
    private Date fechaHoraDevolucion;
}