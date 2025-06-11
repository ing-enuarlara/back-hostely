package com.back.hostely.controller;

import com.back.hostely.model.UsuarioSede;
import com.back.hostely.service.UsuarioSedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario-sedes")
public class UsuarioSedeController {

    @Autowired
    private UsuarioSedeService usuarioSedeService;

    @GetMapping
    public List<UsuarioSede> getAll() {
        return usuarioSedeService.findAll();
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<UsuarioSede> getByUsuario(@PathVariable Long usuarioId) {
        return usuarioSedeService.findByUsuarioId(usuarioId);
    }

    @PostMapping
    public UsuarioSede create(@RequestBody UsuarioSede usuarioSede) {
        return usuarioSedeService.save(usuarioSede);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        usuarioSedeService.deleteById(id);
    }
}