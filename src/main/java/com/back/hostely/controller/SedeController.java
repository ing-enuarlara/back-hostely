package com.back.hostely.controller;

import com.back.hostely.model.Sede;
import com.back.hostely.service.SedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sedes")
@CrossOrigin(origins = "*")
public class SedeController {

    @Autowired
    private SedeService service;

    @GetMapping
    public List<Sede> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Sede> porId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/negocio/{negocioId}")
    public List<Sede> porNegocio(@PathVariable Integer negocioId) {
        return service.buscarPorNegocio(negocioId);
    }

    @PostMapping
    public Sede crear(@RequestBody Sede sede) {
        return service.crear(sede);
    }

    @PutMapping("/{id}")
    public Sede actualizar(@PathVariable Integer id, @RequestBody Sede datos) {
        return service.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}