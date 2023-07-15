package com.example.sena.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="ambiente")
public class Ambientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Integer id;

    @Column(length = 8, nullable = false)
   private Integer floor;

   @Column(length = 267, nullable = false)
   private String nombre;

   @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime creationDateTime;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime lastModified;
}
