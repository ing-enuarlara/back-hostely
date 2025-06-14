package com.back.hostely.controller;

import com.back.hostely.model.HistorialAccion;
import com.back.hostely.service.HistorialAccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/historial-acciones")
@CrossOrigin(origins = "*")
public class HistorialAccionController {

    @Autowired
    private HistorialAccionService service;

    @GetMapping
    public List<HistorialAccion> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<HistorialAccion> porId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<HistorialAccion> porUsuario(@PathVariable Integer usuarioId) {
        return service.buscarPorUsuario(usuarioId);
    }

    @GetMapping("/negocio/{negocioId}")
    public List<HistorialAccion> porNegocio(@PathVariable Integer negocioId) {
        return service.buscarPorNegocio(negocioId);
    }
}