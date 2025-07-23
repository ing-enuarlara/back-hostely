package com.back.hostely.controller;

import com.back.hostely.dto.HorarioPuestoDTO;
import com.back.hostely.mapper.HorarioPuestoMapper;
import com.back.hostely.model.HorarioPuesto;
import com.back.hostely.service.HorarioPuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/horario-puesto")
public class HorarioPuestoController {

    @Autowired
    private HorarioPuestoService service;

    @Autowired
    private HorarioPuestoMapper mapper;

    @GetMapping("/puesto/{puestoId}")
    public ResponseEntity<List<HorarioPuestoDTO>> listarPorPuesto(@PathVariable Integer puestoId) {
        List<HorarioPuesto> funciones = service.listarPorPuesto(puestoId);
        List<HorarioPuestoDTO> dtos = funciones.stream()
                .map(mapper::toDTO)
                .toList();
        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<HorarioPuesto> crear(@RequestBody HorarioPuesto funcion) {
        return ResponseEntity.ok(service.guardar(funcion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HorarioPuestoDTO> actualizar(@PathVariable Integer id, @RequestBody HorarioPuestoDTO dto) {
        HorarioPuesto existente = service.buscarPorId(id);
        existente.setTimeInicio(dto.getTimeInicio());
        existente.setTimeFin(dto.getTimeFin());
        HorarioPuesto guardado = service.guardar(existente);
        return ResponseEntity.ok(mapper.toDTO(guardado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}