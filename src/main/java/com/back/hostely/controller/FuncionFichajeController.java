package com.back.hostely.controller;

import com.back.hostely.dto.FuncionFichajeDTO;
import com.back.hostely.model.FuncionFichaje;
import com.back.hostely.enums.EstadoFuncion;
import com.back.hostely.repository.FuncionFichajeRepository;
import com.back.hostely.service.FuncionFichajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/funciones-fichaje")
public class FuncionFichajeController {

    @Autowired
    private FuncionFichajeService service;

    @Autowired
    private FuncionFichajeRepository repo;

    @GetMapping("/fichaje/{fichajeId}")
    public ResponseEntity<?> listarFunciones(@PathVariable Integer fichajeId) {
        List<FuncionFichaje> lista = service.listarPorFichaje(fichajeId);
        List<FuncionFichajeDTO> dtos = lista.stream().map(FuncionFichajeDTO::new).toList();
        return ResponseEntity.ok(dtos);
    }

    @PatchMapping("/estado/{id}")
    public ResponseEntity<?> actualizarEstado(@PathVariable Integer id, @RequestBody Map<String, String> body) {
        String nuevoEstado = body.get("estado");

        FuncionFichaje funcion = repo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Función no encontrada"));

        funcion.setEstado(EstadoFuncion.valueOf(nuevoEstado));
        repo.save(funcion);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/generar")
    public ResponseEntity<?> generarFuncionesPorFichaje(@RequestBody Map<String, Object> body) {
        Integer puestoId = (Integer) body.get("puestoId");
        Integer fichajeId = (Integer) body.get("fichajeId");
        String fechaStr = (String) body.get("fecha");

        LocalDate fecha = LocalDate.parse(fechaStr); // asegurarse que venga en formato yyyy-MM-dd

        service.generarPorFichaje(puestoId, fichajeId, fecha);
        return ResponseEntity.ok("Funciones generadas para el fichaje.");
    }
}