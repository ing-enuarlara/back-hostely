package com.back.hostely.controller;

import com.back.hostely.model.Usuario;
import com.back.hostely.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<Usuario> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> porId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/buscar")
    public List<Usuario> porNombre(@RequestParam String nombre) {
        return service.buscarPorNombre(nombre);
    }

    @GetMapping("/negocio/{negocioId}")
    public List<Usuario> porNegocio(@PathVariable Integer negocioId) {
        return service.buscarPorNegocio(negocioId);
    }

    @PostMapping
    public Usuario crear(@RequestBody Usuario u) {
        return service.crear(u);
    }

    @PutMapping("/{id}")
    public Usuario actualizar(@PathVariable Integer id, @RequestBody Usuario datos) {
        return service.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}