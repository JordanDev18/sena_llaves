/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sena.controller;

import com.example.sena.model.entity.Prestamo;
import com.example.sena.service.PrestamoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.annotation.Validated;
import lombok.RequiredArgsConstructor;
/**
 *
 * @author LENOVO
 */

 @Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @GetMapping("/{id}")
    public ResponseEntity<Prestamo> getPrestamoById(@PathVariable Integer id) {
        Prestamo prestamo = prestamoService.findById(id);
        if (prestamo != null) {
            return ResponseEntity.ok(prestamo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Prestamo>> getAllPrestamos() {
        List<Prestamo> prestamos = prestamoService.findAll();
        if (!prestamos.isEmpty()) {
            return ResponseEntity.ok(prestamos);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity<Prestamo> createPrestamo(@RequestBody Prestamo prestamo) {
        Prestamo nuevoPrestamo = prestamoService.createPrestamo(prestamo);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPrestamo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrestamo(@PathVariable Integer id) {
        prestamoService.deletePrestamo(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/devolver")
    public ResponseEntity<Void> marcarComoDevuelto(@PathVariable Integer id) {
        prestamoService.marcarComoDevuelto(id);
        return ResponseEntity.noContent().build();
    }
}