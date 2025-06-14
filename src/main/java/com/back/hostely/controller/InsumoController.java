package com.back.hostely.controller;

import com.back.hostely.model.Insumo;
import com.back.hostely.service.InsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/insumos")
@CrossOrigin(origins = "*")
public class InsumoController {

    @Autowired
    private InsumoService service;

    @GetMapping
    public List<Insumo> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Insumo> porId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/buscar")
    public List<Insumo> porNombre(@RequestParam String nombre) {
        return service.buscarPorNombre(nombre);
    }

    @GetMapping("/negocio/{negocioId}")
    public List<Insumo> porNegocio(@PathVariable Integer negocioId) {
        return service.buscarPorNegocio(negocioId);
    }

    @PostMapping
    public Insumo crear(@RequestBody Insumo insumo) {
        return service.crear(insumo);
    }

    @PutMapping("/{id}")
    public Insumo actualizar(@PathVariable Integer id, @RequestBody Insumo datos) {
        return service.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}