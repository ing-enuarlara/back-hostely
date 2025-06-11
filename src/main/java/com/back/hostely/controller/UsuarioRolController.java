package com.back.hostely.controller;

import com.back.hostely.model.UsuarioRol;
import com.back.hostely.service.UsuarioRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario-roles")
public class UsuarioRolController {

    @Autowired
    private UsuarioRolService usuarioRolService;

    @GetMapping
    public List<UsuarioRol> getAll() {
        return usuarioRolService.findAll();
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<UsuarioRol> getByUsuario(@PathVariable Long usuarioId) {
        return usuarioRolService.findByUsuarioId(usuarioId);
    }

    @PostMapping
    public UsuarioRol create(@RequestBody UsuarioRol usuarioRol) {
        return usuarioRolService.save(usuarioRol);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        usuarioRolService.deleteById(id);
    }
}