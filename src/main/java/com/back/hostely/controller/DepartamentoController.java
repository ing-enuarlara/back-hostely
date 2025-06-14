package com.back.hostely.controller;

import com.back.hostely.model.Departamento;
import com.back.hostely.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/departamentos")
@CrossOrigin(origins = "*")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public List<Departamento> listarTodos() {
        return departamentoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Departamento> buscarPorId(@PathVariable Integer id) {
        return departamentoService.obtenerPorId(id);
    }
}