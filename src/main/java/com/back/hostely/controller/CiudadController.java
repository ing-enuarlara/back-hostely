package com.back.hostely.controller;

import com.back.hostely.model.Ciudad;
import com.back.hostely.service.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ciudades")
@CrossOrigin(origins = "*")
public class CiudadController {

    @Autowired
    private CiudadService ciudadService;

    @GetMapping
    public List<Ciudad> listarTodas() {
        return ciudadService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Optional<Ciudad> obtenerPorId(@PathVariable Integer id) {
        return ciudadService.obtenerPorId(id);
    }
}