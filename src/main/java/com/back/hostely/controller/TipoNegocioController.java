package com.back.hostely.controller;

import com.back.hostely.model.TipoNegocio;
import com.back.hostely.service.TipoNegocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tipos-negocios")
@CrossOrigin(origins = "*")
public class TipoNegocioController {

    @Autowired
    private TipoNegocioService service;

    @GetMapping
    public List<TipoNegocio> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<TipoNegocio> porId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/buscar")
    public List<TipoNegocio> buscarPorNombre(@RequestParam String nombre) {
        return service.buscarPorNombre(nombre);
    }

    @PostMapping
    public TipoNegocio crear(@RequestBody TipoNegocio tipo) {
        return service.crear(tipo);
    }

    @PutMapping("/{id}")
    public TipoNegocio actualizar(@PathVariable Integer id, @RequestBody TipoNegocio datos) {
        return service.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}