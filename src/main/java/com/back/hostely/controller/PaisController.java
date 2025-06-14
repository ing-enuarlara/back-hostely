package com.back.hostely.controller;

import com.back.hostely.model.Pais;
import com.back.hostely.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/paises")
@CrossOrigin(origins = "*")
public class PaisController {

    @Autowired
    private PaisService paisService;

    @GetMapping
    public List<Pais> listarPaises() {
        return paisService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Pais> obtenerPais(@PathVariable Integer id) {
        return paisService.obtenerPorId(id);
    }
}