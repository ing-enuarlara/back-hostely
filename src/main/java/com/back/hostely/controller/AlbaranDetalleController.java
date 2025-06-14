package com.back.hostely.controller;

import com.back.hostely.model.AlbaranDetalle;
import com.back.hostely.service.AlbaranDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/albaran-detalle")
@CrossOrigin(origins = "*")
public class AlbaranDetalleController {

    @Autowired
    private AlbaranDetalleService service;

    @GetMapping
    public List<AlbaranDetalle> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<AlbaranDetalle> porId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/albaran/{albaranId}")
    public List<AlbaranDetalle> porAlbaran(@PathVariable Integer albaranId) {
        return service.buscarPorAlbaran(albaranId);
    }

    @PostMapping
    public AlbaranDetalle crear(@RequestBody AlbaranDetalle d) {
        return service.crear(d);
    }

    @PutMapping("/{id}")
    public AlbaranDetalle actualizar(@PathVariable Integer id, @RequestBody AlbaranDetalle datos) {
        return service.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}