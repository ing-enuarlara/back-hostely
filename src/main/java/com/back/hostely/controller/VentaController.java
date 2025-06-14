package com.back.hostely.controller;

import com.back.hostely.model.Venta;
import com.back.hostely.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ventas")
@CrossOrigin(origins = "*")
public class VentaController {

    @Autowired
    private VentaService service;

    @GetMapping
    public List<Venta> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Venta> porId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/sede/{sedeId}")
    public List<Venta> porSede(@PathVariable Integer sedeId) {
        return service.buscarPorSede(sedeId);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Venta> porUsuario(@PathVariable Integer usuarioId) {
        return service.buscarPorUsuario(usuarioId);
    }

    @PostMapping
    public Venta crear(@RequestBody Venta venta) {
        return service.crear(venta);
    }

    @PutMapping("/{id}")
    public Venta actualizar(@PathVariable Integer id, @RequestBody Venta datos) {
        return service.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}