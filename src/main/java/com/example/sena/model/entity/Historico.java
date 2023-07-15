/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sena.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author LENOVO
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="historico")
public class Historico {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Integer id;
     
     @ManyToOne
    @JoinColumn(name = "llave_id")
    private LlavesPrestramo llave;

    @ManyToOne
    @JoinColumn(name = "instructor_id" , referencedColumnName = "id")
    private Usuario instructor;

    @ManyToOne
    @JoinColumn(name = "funcionario_id" , referencedColumnName = "id")
    private Usuario funcionario;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraPrestamo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraDevolucion;
}
