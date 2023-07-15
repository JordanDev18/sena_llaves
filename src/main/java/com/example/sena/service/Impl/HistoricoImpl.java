/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sena.service.Impl;

import com.example.sena.model.entity.Historico;
import com.example.sena.repository.HistoricoRepository;
import com.example.sena.service.HistoricoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LENOVO
 */
@Service
public class HistoricoImpl implements HistoricoService {

    
    @Autowired
    private HistoricoRepository historicoRepository;

    @Override
    public Historico findById(Integer id) {
        return historicoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Historico> findAll() {
        return historicoRepository.findAll();
    }

    @Override
    public Historico createHistorico(Historico historico) {
        return historicoRepository.save(historico);
    }

    @Override
    public void deleteHistorico(Integer id) {
        historicoRepository.deleteById(id);
    }
    
}
