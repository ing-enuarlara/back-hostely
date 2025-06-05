package com.back.hostely.controller;

import com.back.hostely.model.Sede;
import com.back.hostely.service.SedeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sedes")
public class SedeController {

    private final SedeService sedeService;

    public SedeController(SedeService sedeService) {
        this.sedeService = sedeService;
    }

    @GetMapping
    public List<Sede> listar() {
        return sedeService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sede> obtenerPorId(@PathVariable Long id) {
        return sedeService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Sede crear(@RequestBody Sede sede) {
        return sedeService.crear(sede);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sede> actualizar(@PathVariable Long id, @RequestBody Sede datos) {
        return sedeService.buscarPorId(id)
                .map(sede -> {
                    sede.setNombre(datos.getNombre());
                    sede.setDireccion(datos.getDireccion());
                    return ResponseEntity.ok(sedeService.crear(sede));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        sedeService.eliminar(id);
    }
}