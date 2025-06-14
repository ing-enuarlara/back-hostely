package com.back.hostely.controller;

import com.back.hostely.model.UsuarioSede;
import com.back.hostely.service.UsuarioSedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario-sedes")
@CrossOrigin(origins = "*")
public class UsuarioSedeController {

    @Autowired
    private UsuarioSedeService service;

    @GetMapping
    public List<UsuarioSede> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<UsuarioSede> porId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<UsuarioSede> porUsuario(@PathVariable Integer usuarioId) {
        return service.buscarPorUsuario(usuarioId);
    }

    @GetMapping("/sede/{sedeId}")
    public List<UsuarioSede> porSede(@PathVariable Integer sedeId) {
        return service.buscarPorSede(sedeId);
    }

    @PostMapping
    public UsuarioSede crear(@RequestBody UsuarioSede relacion) {
        return service.crear(relacion);
    }

    @PutMapping("/{id}")
    public UsuarioSede actualizar(@PathVariable Integer id, @RequestBody UsuarioSede datos) {
        return service.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}