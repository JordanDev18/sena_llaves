package com.example.sena.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.sena.model.dto.LlavesDTO;
import com.example.sena.model.entity.LlavesPrestramo;
import com.example.sena.repository.LlavesRepositoy;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@Service
@Transactional
@RequiredArgsConstructor
public class LlavesService {

    private final LlavesRepositoy llavesRepositoy;

    public Page<LlavesPrestramo> getProductosPaginate(Pageable paging) {
        return llavesRepositoy.findAll(paging);
    }

    public Page<LlavesPrestramo> getProductosPaginateByExample(Pageable paging, Example<LlavesPrestramo> example) {
        return llavesRepositoy.findAll(example, paging);
    }

    public boolean alreadyExistByCodigo(String codigo) {
        return false;
    }

    public void updateProducto(LlavesPrestramo producto) {
        llavesRepositoy.save(producto);
    }

    public boolean alreadyExistById(Integer idLlaves) {
        return llavesRepositoy.existsById(idLlaves);
    }

    public void deleteProductoById(Integer idLlaves) {
        llavesRepositoy.deleteById(idLlaves);
    }

    public boolean codigoDisponible(String codigo) {
        Example<LlavesPrestramo> example = Example.of(LlavesPrestramo.builder().codigo(codigo).build());
        return llavesRepositoy.exists(example);
    }

    public Optional<LlavesPrestramo> getProductoByCodigo(String codigo) {
        return llavesRepositoy.findFirstByCodigo(codigo);
    }

    public Optional<LlavesPrestramo> getProductoById(Integer idLlaves) {
        return llavesRepositoy.findById(idLlaves);
    }

    public void habilitarProducto(LlavesPrestramo producto) {
        llavesRepositoy.habilitarProductoById(producto.getId());
    }

    public void deshabilitarProducto(LlavesPrestramo producto) {
        llavesRepositoy.deshabilitarProductoById(producto.getId());
    }

    public boolean codigoDisponible(LlavesDTO llavesDTO) {
        Optional<LlavesPrestramo> optional = getProductoByCodigo(llavesDTO.getCodigo());
        if(optional.isPresent()){
            LlavesPrestramo producto = optional.get();
            return producto.getId().equals(llavesDTO.getId());
        }
        return true;
    }

    public void createProducto(LlavesPrestramo producto) {
        llavesRepositoy.save(producto);
    }

    public void saveAll(List<LlavesPrestramo> productos) {
        llavesRepositoy.saveAll(productos);
    }
    
}