/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.sena.service;

import com.example.sena.model.entity.Prestamo;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface PrestamoService {
    Prestamo findById(Integer id);
    List<Prestamo> findAll();
    Prestamo createPrestamo(Prestamo prestamo);
    void deletePrestamo(Integer id);
    void marcarComoDevuelto(Integer id);
}
