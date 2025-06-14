package com.back.hostely.controller;

import com.back.hostely.model.VentaDetalle;
import com.back.hostely.service.VentaDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/venta-detalle")
@CrossOrigin(origins = "*")
public class VentaDetalleController {

    @Autowired
    private VentaDetalleService service;

    @GetMapping
    public List<VentaDetalle> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<VentaDetalle> porId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/venta/{ventaId}")
    public List<VentaDetalle> porVenta(@PathVariable Integer ventaId) {
        return service.buscarPorVenta(ventaId);
    }

    @PostMapping
    public VentaDetalle crear(@RequestBody VentaDetalle detalle) {
        return service.crear(detalle);
    }

    @PutMapping("/{id}")
    public VentaDetalle actualizar(@PathVariable Integer id, @RequestBody VentaDetalle datos) {
        return service.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}