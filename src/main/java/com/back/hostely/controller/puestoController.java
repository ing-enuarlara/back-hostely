package com.back.hostely.controller;

import com.back.hostely.dto.PuestoDTO;
import com.back.hostely.model.Puesto;
import com.back.hostely.service.PuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/puestos")
@CrossOrigin(origins = "*")
public class puestoController {

    @Autowired
    private PuestoService service;

    @GetMapping
    public List<Puesto> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Puesto> porId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/negocio/{negocioId}")
    public List<PuestoDTO> porNegocio(@PathVariable Integer negocioId) {
        return service.buscarPorNegocioConHorarios(negocioId).stream()
                .map(PuestoDTO::new)
                .collect(Collectors.toList());
    }

    @PostMapping
    public Puesto crear(@RequestBody Puesto puesto) {
        return service.crear(puesto);
    }

    @PutMapping("/{id}")
    public Puesto actualizar(@PathVariable Integer id, @RequestBody Puesto datos) {
        return service.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}