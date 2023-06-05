package com.example.sena.model.mapper;

import org.springframework.stereotype.Service;

import com.example.sena.model.dto.AmbienteDTO;
import com.example.sena.model.entity.Ambientes;

@Service
public class AmbienteMapper implements GenericMapper<Ambientes , AmbienteDTO> {

    @Override
    public Ambientes dtoToPojo(AmbienteDTO dto) {
        Ambientes ambientes = Ambientes.builder()
                                    .floor(dto.getFloor())
                                    .nombre(dto.getNombre())
                                    .build();
        if (dto.getId() != null) {
            ambientes.setId(dto.getId());
        }
        return ambientes;
    }

    @Override
    public AmbienteDTO pojoToDto(Ambientes pojo) {
        AmbienteDTO ambienteDTO = AmbienteDTO.builder()
                                    .id(pojo.getId())
                                    .floor(pojo.getFloor())
                                    .nombre(pojo.getNombre())
                                    .build();
        return ambienteDTO;
    }
    
}
