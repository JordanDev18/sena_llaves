/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sena.service;

import com.example.sena.model.entity.Historico;
import java.util.List;
import org.springframework.stereotype.Service;



/**
 *
 * @author LENOVO
 */
public interface HistoricoService {
    Historico findById(Integer id);
    List<Historico> findAll();
    Historico createHistorico(Historico historico);
    void deleteHistorico(Integer id);
}
