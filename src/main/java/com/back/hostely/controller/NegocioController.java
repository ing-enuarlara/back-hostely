package com.back.hostely.controller;

import com.back.hostely.model.Negocio;
import com.back.hostely.service.NegocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/negocios")
@CrossOrigin(origins = "*")
public class NegocioController {

    @Autowired
    private NegocioService service;

    @GetMapping
    public List<Negocio> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Negocio> porId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/buscar")
    public List<Negocio> porNombre(@RequestParam String nombre) {
        return service.buscarPorNombre(nombre);
    }

    @GetMapping("/pais/{paisId}")
    public List<Negocio> porPais(@PathVariable Integer paisId) {
        return service.buscarPorPais(paisId);
    }

    @GetMapping("/tipo/{tipoId}")
    public List<Negocio> porTipo(@PathVariable Integer tipoId) {
        return service.buscarPorTipo(tipoId);
    }

    @PostMapping
    public Negocio crear(@RequestBody Negocio negocio) {
        return service.crear(negocio);
    }

    @PutMapping("/{id}")
    public Negocio actualizar(@PathVariable Integer id, @RequestBody Negocio datos) {
        return service.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}