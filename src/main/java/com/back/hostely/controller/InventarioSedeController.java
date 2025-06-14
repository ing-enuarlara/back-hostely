package com.back.hostely.controller;

import com.back.hostely.model.InventarioSede;
import com.back.hostely.service.InventarioSedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inventario-sede")
@CrossOrigin(origins = "*")
public class InventarioSedeController {

    @Autowired
    private InventarioSedeService service;

    @GetMapping
    public List<InventarioSede> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<InventarioSede> porId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/sede/{sedeId}")
    public List<InventarioSede> porSede(@PathVariable Integer sedeId) {
        return service.buscarPorSede(sedeId);
    }

    @GetMapping("/insumo/{insumoId}")
    public List<InventarioSede> porInsumo(@PathVariable Integer insumoId) {
        return service.buscarPorInsumo(insumoId);
    }

    @PostMapping
    public InventarioSede crear(@RequestBody InventarioSede registro) {
        return service.crear(registro);
    }

    @PutMapping("/{id}")
    public InventarioSede actualizar(@PathVariable Integer id, @RequestBody InventarioSede datos) {
        return service.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}