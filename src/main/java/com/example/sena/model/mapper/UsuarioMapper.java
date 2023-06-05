package com.example.sena.model.mapper;

import org.springframework.stereotype.Service;

import com.example.sena.model.dto.UsuarioDTO;
import com.example.sena.model.entity.Usuario;
import com.example.sena.model.enums.AuthorityEnum;



@Service
public class UsuarioMapper implements GenericMapper<Usuario, UsuarioDTO>{

    @Override
    public Usuario dtoToPojo(UsuarioDTO dto) {
        Usuario usuario = Usuario.builder()
                                .nombre(dto.getNombre())
                                .apellido(dto.getApellido())
                                .telefono(dto.getTelefono())
                                .email(dto.getEmail())
                                .password(dto.getPassword())
                                .authority(AuthorityEnum.valueOf(dto.getAuthority()))
                                .enabled(true)
                                .estado(dto.getEstado())
                                .build();
        if (dto.getId() != null) {
            usuario.setId(dto.getId());
        }
        return usuario;
    }

    @Override
    public UsuarioDTO pojoToDto(Usuario pojo) {
        UsuarioDTO usuarioDTO = UsuarioDTO.builder()
                                        .id(pojo.getId())
                                        .nombre(pojo.getNombre())
                                        .apellido(pojo.getApellido())
                                        .telefono(pojo.getTelefono())
                                        .email(pojo.getEmail())
                                        .password("")
                                        .authority(pojo.getAuthority().toString())
                                        .enabled(pojo.getEnabled())
                                        .estado(pojo.getEstado())
                                        .build();
        return usuarioDTO;
    }
    
}
