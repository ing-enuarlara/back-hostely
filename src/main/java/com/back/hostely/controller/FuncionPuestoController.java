package com.back.hostely.controller;

import com.back.hostely.dto.FuncionPuestoDTO;
import com.back.hostely.mapper.FuncionPuestoMapper;
import com.back.hostely.model.FuncionPuesto;
import com.back.hostely.service.FuncionPuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funciones-puesto")
public class FuncionPuestoController {

    @Autowired
    private FuncionPuestoService service;

    @Autowired
    private FuncionPuestoMapper mapper;

    @GetMapping("/puesto/{puestoId}")
    public ResponseEntity<List<FuncionPuestoDTO>> listarPorPuesto(@PathVariable Integer puestoId) {
        List<FuncionPuesto> funciones = service.listarPorPuesto(puestoId);
        List<FuncionPuestoDTO> dtos = funciones.stream()
                .map(mapper::toDTO)
                .toList();
        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<FuncionPuesto> crear(@RequestBody FuncionPuesto funcion) {
        return ResponseEntity.ok(service.guardar(funcion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionPuestoDTO> actualizar(@PathVariable Integer id, @RequestBody FuncionPuestoDTO dto) {
        FuncionPuesto existente = service.buscarPorId(id);
        existente.setNombre(dto.getNombre());
        existente.setDescripcion(dto.getDescripcion());
        existente.setTime(dto.getTime());
        FuncionPuesto guardado = service.guardar(existente);
        return ResponseEntity.ok(mapper.toDTO(guardado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}