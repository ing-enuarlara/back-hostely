package com.back.hostely.controller;

import com.back.hostely.model.UsuarioRol;
import com.back.hostely.service.UsuarioRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario-roles")
@CrossOrigin(origins = "*")
public class UsuarioRolController {

    @Autowired
    private UsuarioRolService service;

    @GetMapping
    public List<UsuarioRol> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<UsuarioRol> porId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<UsuarioRol> porUsuario(@PathVariable Integer usuarioId) {
        return service.buscarPorUsuario(usuarioId);
    }

    @GetMapping("/rol/{rolId}")
    public List<UsuarioRol> porRol(@PathVariable Integer rolId) {
        return service.buscarPorRol(rolId);
    }

    @PostMapping
    public UsuarioRol crear(@RequestBody UsuarioRol relacion) {
        return service.crear(relacion);
    }

    @PutMapping("/{id}")
    public UsuarioRol actualizar(@PathVariable Integer id, @RequestBody UsuarioRol datos) {
        return service.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}