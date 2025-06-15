package com.back.hostely.controller;

import com.back.hostely.model.NegocioProveedor;
import com.back.hostely.service.NegocioProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/negocio-Proveedor")
@CrossOrigin(origins = "*")
public class NegocioProveedorController {

    @Autowired
    private NegocioProveedorService service;

    @GetMapping
    public List<NegocioProveedor> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<NegocioProveedor> porId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/negocio/{negocioId}")
    public List<NegocioProveedor> porNegocio(@PathVariable Integer negocioId) {
        return service.buscarPorNegocio(negocioId);
    }

    @GetMapping("/proveedor/{proveedorId}")
    public List<NegocioProveedor> porProveedor(@PathVariable Integer proveedorId) {
        return service.buscarPorProveedor(proveedorId);
    }

    @PostMapping
    public NegocioProveedor crear(@RequestBody NegocioProveedor d) {
        return service.crear(d);
    }

    @PutMapping("/{id}")
    public NegocioProveedor actualizar(@PathVariable Integer id, @RequestBody NegocioProveedor datos) {
        return service.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}