package com.example.sena.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.sena.model.entity.Ambientes;
import com.example.sena.repository.AmbientesRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@Service
@Transactional
@RequiredArgsConstructor
public class AmbienteService {

    private final AmbientesRepository ambientesRepository;

    public Page<Ambientes> getProductosPaginate(Pageable paging) {
        return ambientesRepository.findAll(paging);
    }

    public Page<Ambientes> getAmbientePaginateByExample(Pageable paging, Example<Ambientes> example) {
        return ambientesRepository.findAll(example, paging);
    }

    
    public void updateAmbiente(Ambientes ambiente) {
        ambientesRepository.save(ambiente);
    }

    public boolean alreadyExistById(UUID idFloor) {
        return ambientesRepository.existsById(idFloor);
    }

    public void deleteProductoById(UUID idFloor) {
        ambientesRepository.deleteById(idFloor);
    }



    public Optional<Ambientes> getProductoById(UUID idFloor) {
        return ambientesRepository.findById(idFloor);
    }

    public void habilitarProducto(Ambientes ambientes) {
        ambientesRepository.habilitarProductoById(ambientes.getId());
    }

    public void deshabilitarProducto(Ambientes ambientes) {
        ambientesRepository.deshabilitarProductoById(ambientes.getId());
    }



    public void createProducto(Ambientes ambientes) {
        ambientesRepository.save(ambientes);
    }

    public void saveAll(List<Ambientes> ambientes) {
        ambientesRepository.saveAll(ambientes);
    }
    
}
