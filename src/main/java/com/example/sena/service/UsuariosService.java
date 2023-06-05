package com.example.sena.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.sena.configuration.security.model.dto.NewUserRequest;
import com.example.sena.configuration.security.service.AuthenticationService;
import com.example.sena.model.entity.Usuario;
import com.example.sena.model.enums.AuthorityEnum;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UsuariosService {

    private final PasswordEncoder passwordEncoder;
    private final com.example.sena.repository.UsuariosRepository usuariosRepository;
    private final AuthenticationService authenticationService;

    public boolean emailDisponible(String email) {
        Example<Usuario> example = Example.of(Usuario.builder().email(email).build());
        return !usuariosRepository.exists(example);
    }

    public void createNewUser(NewUserRequest newUserRequest) {
        Usuario newUser = Usuario.builder()
                                .nombre(newUserRequest.getNombre())
                                .apellido(newUserRequest.getApellido())
                                .telefono(newUserRequest.getTelefono())
                                .email(newUserRequest.getEmail())
                                .password(passwordEncoder.encode(newUserRequest.getPassword()))
                                .enabled(true)
                                .authority(AuthorityEnum.ROLE_ADMINISTRADOR)
                                .build();
        Usuario saved = usuariosRepository.save(newUser);
        authenticationService.registerNewUserToken(saved);
    }

    public void registerUser(Usuario usuario){
        Usuario saved = usuariosRepository.save(usuario);
        authenticationService.registerNewUserToken(saved);
    }

    public Optional<Usuario> getUsuarioById(UUID idUsuario) {
        return usuariosRepository.findById(idUsuario);
    }

    public Page<Usuario> getUsuariosPaginate(Pageable paging) {
        return usuariosRepository.findAll(paging);
    }
    
}
