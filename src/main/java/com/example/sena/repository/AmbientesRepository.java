package com.example.sena.repository;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.sena.model.entity.Ambientes;

import jakarta.transaction.Transactional;

@Repository
public interface AmbientesRepository extends JpaRepository<Ambientes, UUID> {
   

    @Modifying
    @Transactional
    @Query(value="UPDATE ambiente p SET p.disponible = 1 WHERE p.id = :idFloor" , nativeQuery = true)
    void habilitarProductoById(UUID idFloor);

    @Modifying
    @Transactional
    @Query(value="UPDATE ambiente p SET p.disponible = 0 WHERE p.id = :idFloor" , nativeQuery = true)
    void deshabilitarProductoById(UUID idFloor);
    
}
