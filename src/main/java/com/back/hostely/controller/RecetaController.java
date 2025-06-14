package com.back.hostely.controller;

import com.back.hostely.model.Receta;
import com.back.hostely.service.RecetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recetas")
@CrossOrigin(origins = "*")
public class RecetaController {

    @Autowired
    private RecetaService service;

    @GetMapping
    public List<Receta> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Receta> porId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/producto/{productoId}")
    public List<Receta> porProducto(@PathVariable Integer productoId) {
        return service.buscarPorProducto(productoId);
    }

    @PostMapping
    public Receta crear(@RequestBody Receta receta) {
        return service.crear(receta);
    }

    @PutMapping("/{id}")
    public Receta actualizar(@PathVariable Integer id, @RequestBody Receta datos) {
        return service.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}