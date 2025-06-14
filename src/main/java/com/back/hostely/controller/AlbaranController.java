package com.back.hostely.controller;

import com.back.hostely.model.Albaran;
import com.back.hostely.service.AlbaranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/albaranes")
@CrossOrigin(origins = "*")
public class AlbaranController {

    @Autowired
    private AlbaranService service;

    @GetMapping
    public List<Albaran> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Albaran> porId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/sede/{sedeId}")
    public List<Albaran> porSede(@PathVariable Integer sedeId) {
        return service.buscarPorSede(sedeId);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Albaran> porUsuario(@PathVariable Integer usuarioId) {
        return service.buscarPorUsuario(usuarioId);
    }

    @PostMapping
    public Albaran crear(@RequestBody Albaran registro) {
        return service.crear(registro);
    }

    @PutMapping("/{id}")
    public Albaran actualizar(@PathVariable Integer id, @RequestBody Albaran datos) {
        return service.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}