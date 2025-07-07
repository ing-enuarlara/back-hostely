package com.back.hostely.controller;

import com.back.hostely.dto.RolDTO;
import com.back.hostely.model.Rol;
import com.back.hostely.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins = "*")
public class RolController {

    @Autowired
    private RolService service;

    @GetMapping
    public List<Rol> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Rol> buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/negocio/{negocioId}")
    public List<Rol> buscarPorNegocio(@PathVariable Integer negocioId) {
        return service.buscarPorNegocio(negocioId);
    }

    @PostMapping
    public Rol crear(@RequestBody RolDTO dto) {
        return service.crearConPermisos(dto);
    }

    @PutMapping("/{id}")
    public Rol actualizar(@PathVariable Integer id, @RequestBody Rol datos) {
        return service.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }

    @GetMapping("/negocioConGlobales/{negocioId}")
    public List<Rol> buscarConGlobales(@PathVariable Integer negocioId) {
        return service.buscarConGlobales(negocioId);
    }

    @PostMapping("/{id}/permisos")
    public void asignarPermisos(@PathVariable Integer id, @RequestBody List<Integer> permisoIds) {
        service.asignarPermisos(id, permisoIds);
    }
}