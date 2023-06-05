package com.example.sena.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sena.configuration.exception.CodigoNotAvaliableException;
import com.example.sena.configuration.exception.EntityAlreadyOnStateException;
import com.example.sena.model.dto.LlavesDTO;
import com.example.sena.model.entity.LlavesPrestramo;
import com.example.sena.model.mapper.LlavesMapper;
import com.example.sena.service.LlavesService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/productos")
public class LlavesController {

    private final LlavesService llavesService;
    private final LlavesMapper llavesMapper;

    @GetMapping("/paginate")
    public ResponseEntity<Page<LlavesDTO>> handleGetProductos(
            @RequestParam(defaultValue = "0") final Integer page,
            @RequestParam(defaultValue = "9") final Integer size) {

        final Pageable paging = PageRequest.of(page, size);
        final Page<LlavesPrestramo> pageProductos = llavesService.getProductosPaginate(paging);
        System.out.println(pageProductos);
        final Page<LlavesDTO> pageProductosDTO = new PageImpl<LlavesDTO>(
                pageProductos.stream().map(llavesMapper::pojoToDto).toList());
                System.out.println(pageProductosDTO);
        return ResponseEntity.status(HttpStatus.OK).body(pageProductosDTO);

    }

    @GetMapping("/filtered")
    public ResponseEntity<Page<LlavesDTO>> handleGetProductosByExample(
            @RequestParam(defaultValue = "0") final Integer page,
            @RequestParam(defaultValue = "9") final Integer size,
            @RequestBody final LlavesDTO llavesDTO) {
        final Pageable paging = PageRequest.of(page, size);
        final Example<LlavesPrestramo> example = Example
                .of(llavesMapper.dtoToPojo(llavesDTO));
        final Page<LlavesPrestramo> pageLlaves = llavesService.getProductosPaginateByExample(paging, example);
        final Page<LlavesDTO> pageProductosDTO = new PageImpl<LlavesDTO>(
                pageLlaves.stream().map(llavesMapper::pojoToDto).toList());
        return ResponseEntity.status(HttpStatus.OK).body(pageProductosDTO);
    }

    @GetMapping("/codigo")
    public ResponseEntity<LlavesDTO> handleGetProductoByCodigo(@RequestParam final String codigo)
            throws EntityNotFoundException {
        Optional<LlavesPrestramo> optional = llavesService.getProductoByCodigo(codigo);
        if (!optional.isPresent()) {
            throw new EntityNotFoundException(String.format("Producto no encontrado. Codigo: %s", codigo));
        }
        final LlavesPrestramo llavesPrestramo = optional.get();
        final LlavesDTO llavesDTO = llavesMapper.pojoToDto(llavesPrestramo);
        return ResponseEntity.status(HttpStatus.OK).body(llavesDTO);
    }

    @GetMapping("/codigo-disponible")
    public ResponseEntity<Boolean> handleCodigoDisponible(@RequestParam final String codigo)
            throws EntityNotFoundException {
        final Boolean disponible = llavesService.codigoDisponible(codigo);
        return ResponseEntity.status(HttpStatus.OK).body(disponible);
    }

    @PutMapping("/update/{idProducto}")
    public ResponseEntity<HttpStatus> handleUpdateProducto(@PathVariable UUID idProducto,
            @RequestBody final LlavesDTO llavesDTO)
            throws EntityNotFoundException, CodigoNotAvaliableException {
        if (!llavesService.alreadyExistById(idProducto)) {
            throw new EntityNotFoundException(String.format("Producto no encontrado. UUID: %s", llavesDTO.getId()));
        } else if (!llavesService.codigoDisponible(llavesDTO)) {
            throw new CodigoNotAvaliableException(
                    String.format("Codigo no disponible. Codigo: %s", llavesDTO.getCodigo()));
        }
        final LlavesPrestramo producto = llavesMapper.dtoToPojo(llavesDTO);
        llavesService.updateProducto(producto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> handleCreateProducto(@RequestBody LlavesDTO llavesDTO)
            throws EntityAlreadyOnStateException {
        if (!llavesService.codigoDisponible(llavesDTO)) {
            throw new CodigoNotAvaliableException(
                    String.format("Codigo no disponible. Codigo: %s", llavesDTO.getCodigo()));
        }
        LlavesPrestramo llavesPrestramo = llavesMapper.dtoToPojo(llavesDTO);
        llavesService.createProducto(llavesPrestramo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping("/habilitar/{codigo}")
    public ResponseEntity<HttpStatus> handleHabilitarProductoByCodigo(@PathVariable("codigo") String codigo)
            throws EntityNotFoundException, EntityAlreadyOnStateException {
        Optional<LlavesPrestramo> optional = llavesService.getProductoByCodigo(codigo);
        if (!optional.isPresent()) {
            throw new EntityNotFoundException("Producto no disponible. No puede ser habilitado");
        } else if (optional.get().getDisponible()) {
            throw new EntityAlreadyOnStateException("Producto se encuentra habilitado. No puede ser habilitado");
        }
        llavesService.habilitarProducto(optional.get());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PatchMapping("/inhabilitar/{codigo}")
    public ResponseEntity<HttpStatus> handleInhabilitarProductoByCodigo(@PathVariable("codigo") String codigo)
            throws EntityNotFoundException, EntityAlreadyOnStateException {
        Optional<LlavesPrestramo> optional = llavesService.getProductoByCodigo(codigo);
        if (!optional.isPresent()) {
            throw new EntityNotFoundException("Producto no disponible. No puede ser habilitado");
        } else if (!optional.get().getDisponible()) {
            throw new EntityAlreadyOnStateException("Producto se encuentra deshabilitado. No puede ser deshabilitado");
        }
        llavesService.deshabilitarProducto(optional.get());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/delete/{idLlaves}")
    public ResponseEntity<HttpStatus> handleDeleteProducto(@PathVariable UUID idLlaves) {
        if (!llavesService.alreadyExistById(idLlaves)) {
            throw new EntityNotFoundException(String.format("Producto no encontrado. UUID: %s", idLlaves));
        }
        llavesService.deleteProductoById(idLlaves);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @InitBinder
    public void initBinder(final WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

}
