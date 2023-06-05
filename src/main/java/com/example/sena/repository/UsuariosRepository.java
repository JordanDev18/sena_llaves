package com.example.sena.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sena.model.entity.Usuario;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, UUID>{

    Optional<Usuario> findFirstByEmail(String email);
    
}
