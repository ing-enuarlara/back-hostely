package com.back.hostely.controller;

import com.back.hostely.model.Fichaje;
import com.back.hostely.service.FichajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fichaje")
@CrossOrigin(origins = "*")
public class FichajeController {

    @Autowired
    private FichajeService service;

    @GetMapping
    public List<Fichaje> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Fichaje> porId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Fichaje> porUsuario(@PathVariable Integer usuarioId) {
        return service.buscarPorUsuario(usuarioId);
    }

    @GetMapping("/puesto/{puestoId}")
    public List<Fichaje> porPuesto(@PathVariable Integer puestoId) {
        return service.buscarPorPuesto(puestoId);
    }

    @GetMapping("/sede/{sedeId}")
    public List<Fichaje> porSede(@PathVariable Integer sedeId) {
        return service.buscarPorSede(sedeId);
    }

    @GetMapping("/negocio/{negocioId}")
    public List<Fichaje> porNegocio(@PathVariable Integer negocioId) {
        return service.buscarPorNegocio(negocioId);
    }

    @PostMapping
    public Fichaje registrar(@RequestBody Fichaje fichaje) {
        return service.registrar(fichaje);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}