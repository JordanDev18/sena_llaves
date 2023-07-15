/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sena.model.mapper;

import com.example.sena.model.dto.HistoricoDTO;
import com.example.sena.model.entity.Historico;
import com.example.sena.repository.LlavesRepositoy;
import com.example.sena.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LENOVO
 */
@Service
public class HistoricoMapper implements GenericMapper<Historico, HistoricoDTO> {


    @Override
    public Historico dtoToPojo(HistoricoDTO dto) {
        Historico historico = Historico.builder()
                .llave(dtoToPojo(dto).getLlave())
                .instructor(dtoToPojo(dto).getInstructor())
                .funcionario(dtoToPojo(dto).getFuncionario())
                .fechaHoraPrestamo(dto.getFechaHoraPrestamo())
                .fechaHoraDevolucion(dto.getFechaHoraDevolucion())
                .build();

        if (dto.getId() != null) {
            historico.setId(dto.getId());
        }

        return historico;
    }

    @Override
    public HistoricoDTO pojoToDto(Historico pojo) {
        HistoricoDTO historicoDTO = HistoricoDTO.builder()
                .id(pojo.getId())
                .llaveId(pojoToDto(pojo).getLlaveId())
                .instructorId(pojoToDto(pojo).getInstructorId())
                .funcionarioId(pojoToDto(pojo).getFuncionarioId())
                .fechaHoraPrestamo(pojo.getFechaHoraPrestamo())
                .fechaHoraDevolucion(pojo.getFechaHoraDevolucion())
                .build();

        return historicoDTO;
    }
}
