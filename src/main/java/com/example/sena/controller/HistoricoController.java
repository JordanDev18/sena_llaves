/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sena.controller;
import com.example.sena.model.entity.Historico;
import com.example.sena.service.HistoricoService;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
/**
 *
 * @author LENOVO
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/historicos")
public class HistoricoController {

    @Autowired
    private HistoricoService historicoService;

    @GetMapping("/{id}")
    public ResponseEntity<Historico> getHistoricoById(@PathVariable Integer id) {
        Historico historico = historicoService.findById(id);
        if (historico != null) {
            return ResponseEntity.ok(historico);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Historico>> getAllHistoricos() {
        List<Historico> historicos = historicoService.findAll();
        if (!historicos.isEmpty()) {
            return ResponseEntity.ok(historicos);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Historico> createHistorico(@RequestBody Historico historico) {
        Historico nuevoHistorico = historicoService.createHistorico(historico);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoHistorico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHistorico(@PathVariable Integer id) {
        historicoService.deleteHistorico(id);
        return ResponseEntity.noContent().build();
    }
}
