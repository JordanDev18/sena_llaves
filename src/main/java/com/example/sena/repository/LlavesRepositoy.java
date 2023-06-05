package com.example.sena.repository;


import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.sena.model.entity.LlavesPrestramo;

import jakarta.transaction.Transactional;

@Repository
public interface LlavesRepositoy extends JpaRepository<LlavesPrestramo, UUID> {

    Optional<LlavesPrestramo> findFirstByCodigo(String codigo);

    @Modifying
    @Transactional
    @Query(value="UPDATE llaves p SET p.disponible = 1 WHERE p.id = :idLlaves" , nativeQuery = true)
    void habilitarProductoById(UUID idLlaves);

    @Modifying
    @Transactional
    @Query(value="UPDATE productos p SET p.disponible = 0 WHERE p.id = :idProducto" , nativeQuery = true)
    void deshabilitarProductoById(UUID idLlaves);
    
}
