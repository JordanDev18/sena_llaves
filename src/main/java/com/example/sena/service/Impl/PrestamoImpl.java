/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sena.service.Impl;

import com.example.sena.model.entity.Prestamo;
import com.example.sena.repository.PrestamoRepository;
import com.example.sena.service.PrestamoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LENOVO
 */
@Service
public class PrestamoImpl implements PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Override
    public Prestamo findById(Integer id) {
        return prestamoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Prestamo> findAll() {
        return prestamoRepository.findAll();
    }

    @Override
    public Prestamo createPrestamo(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    @Override
    public void deletePrestamo(Integer id) {
        prestamoRepository.deleteById(id);
    }

    @Override
    public void marcarComoDevuelto(Integer id) {
        Prestamo prestamo = prestamoRepository.findById(id).orElse(null);
        if (prestamo != null) {
            prestamo.marcarComoDevuelto();
            prestamoRepository.save(prestamo);
        }
    }
}