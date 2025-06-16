package com.back.hostely.controller;

import com.back.hostely.model.UsuarioEmpleado;
import com.back.hostely.service.UsuarioEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario-empleado")
@CrossOrigin(origins = "*")
public class UsuarioEmpleadoController {

    @Autowired
    private UsuarioEmpleadoService service;

    @GetMapping
    public List<UsuarioEmpleado> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<UsuarioEmpleado> porId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<UsuarioEmpleado> porUsuario(@PathVariable Integer usuarioId) {
        return service.buscarPorUsuario(usuarioId);
    }

    @PostMapping
    public UsuarioEmpleado crear(@RequestBody UsuarioEmpleado relacion) {
        return service.crear(relacion);
    }

    @PutMapping("/{id}")
    public UsuarioEmpleado actualizar(@PathVariable Integer id, @RequestBody UsuarioEmpleado datos) {
        return service.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}