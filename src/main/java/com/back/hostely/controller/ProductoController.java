package com.back.hostely.controller;

import com.back.hostely.model.Producto;
import com.back.hostely.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProductoController {

    @Autowired
    private ProductoService service;

    @GetMapping
    public List<Producto> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Producto> porId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/buscar")
    public List<Producto> porNombre(@RequestParam String nombre) {
        return service.buscarPorNombre(nombre);
    }

    @GetMapping("/negocio/{negocioId}")
    public List<Producto> porNegocio(@PathVariable Integer negocioId) {
        return service.buscarPorNegocio(negocioId);
    }

    @PostMapping
    public Producto crear(@RequestBody Producto p) {
        return service.crear(p);
    }

    @PutMapping("/{id}")
    public Producto actualizar(@PathVariable Integer id, @RequestBody Producto datos) {
        return service.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}