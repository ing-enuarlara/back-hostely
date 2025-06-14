package com.back.hostely.controller;

import com.back.hostely.model.LogAccion;
import com.back.hostely.service.LogAccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/log-acciones")
@CrossOrigin(origins = "*")
public class LogAccionController {

    @Autowired
    private LogAccionService service;

    @GetMapping
    public List<LogAccion> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<LogAccion> porId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }
}