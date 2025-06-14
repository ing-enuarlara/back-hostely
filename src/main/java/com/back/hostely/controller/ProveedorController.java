package com.back.hostely.controller;

import com.back.hostely.model.Proveedor;
import com.back.hostely.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/proveedores")
@CrossOrigin(origins = "*")
public class ProveedorController {

    @Autowired
    private ProveedorService service;

    @GetMapping
    public List<Proveedor> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Proveedor> buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/buscar")
    public List<Proveedor> buscarPorNombre(@RequestParam String nombre) {
        return service.buscarPorNombre(nombre);
    }

    @PostMapping
    public Proveedor crear(@RequestBody Proveedor proveedor) {
        return service.crear(proveedor);
    }

    @PutMapping("/{id}")
    public Proveedor actualizar(@PathVariable Integer id, @RequestBody Proveedor datos) {
        return service.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}