package com.example.sena.model.mapper;

import org.springframework.stereotype.Service;

import com.example.sena.model.dto.LlavesDTO;
import com.example.sena.model.entity.LlavesPrestramo;

@Service
public class LlavesMapper implements GenericMapper<LlavesPrestramo, LlavesDTO>{

    @Override
    public LlavesPrestramo dtoToPojo(LlavesDTO dto) {
        LlavesPrestramo llaves = LlavesPrestramo.builder()
                                    .codigo(dto.getCodigo())
                                    .nombre(dto.getNombre())
                                    .disponible(dto.getDisponible())
                                    .cantidad(dto.getCantidad())
                                    .build();
        if (dto.getId() != null) {
            llaves.setId(dto.getId());
        }
        return llaves;
    }

    @Override
    public LlavesDTO pojoToDto(LlavesPrestramo pojo) {
        LlavesDTO productoDTO = LlavesDTO.builder()
                                    .id(pojo.getId())
                                    .codigo(pojo.getCodigo())
                                    .nombre(pojo.getNombre())
                                    .disponible(pojo.getDisponible())
                                    .cantidad(pojo.getCantidad())
                                    .build();
        return productoDTO;
    }
    
}