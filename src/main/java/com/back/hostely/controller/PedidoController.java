package com.back.hostely.controller;

import com.back.hostely.model.Pedido;
import com.back.hostely.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @GetMapping
    public List<Pedido> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Pedido> porId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/sede/{sedeId}")
    public List<Pedido> porSede(@PathVariable Integer sedeId) {
        return service.buscarPorSede(sedeId);
    }

    @GetMapping("/proveedor/{proveedorId}")
    public List<Pedido> porProveedor(@PathVariable Integer proveedorId) {
        return service.buscarPorProveedor(proveedorId);
    }

    @PostMapping
    public Pedido crear(@RequestBody Pedido pedido) {
        return service.crear(pedido);
    }

    @PutMapping("/{id}")
    public Pedido actualizar(@PathVariable Integer id, @RequestBody Pedido datos) {
        return service.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}