package com.back.hostely.controller;

import com.back.hostely.model.ReporteError;
import com.back.hostely.service.ReporteErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/errores")
@CrossOrigin(origins = "*")
public class ReporteErrorController {

    @Autowired
    private ReporteErrorService service;

    @GetMapping
    public List<ReporteError> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<ReporteError> porId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<ReporteError> porUsuario(@PathVariable Integer usuarioId) {
        return service.buscarPorUsuario(usuarioId);
    }

    @GetMapping("/negocio/{negocioId}")
    public List<ReporteError> porNegocio(@PathVariable Integer negocioId) {
        return service.buscarPorNegocio(negocioId);
    }
}