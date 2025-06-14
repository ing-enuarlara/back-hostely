package com.back.hostely.controller;

import com.back.hostely.model.PedidoDetalle;
import com.back.hostely.service.PedidoDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedido-detalle")
@CrossOrigin(origins = "*")
public class PedidoDetalleController {

    @Autowired
    private PedidoDetalleService service;

    @GetMapping
    public List<PedidoDetalle> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<PedidoDetalle> porId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/pedido/{pedidoId}")
    public List<PedidoDetalle> porPedido(@PathVariable Integer pedidoId) {
        return service.buscarPorPedido(pedidoId);
    }

    @PostMapping
    public PedidoDetalle crear(@RequestBody PedidoDetalle detalle) {
        return service.crear(detalle);
    }

    @PutMapping("/{id}")
    public PedidoDetalle actualizar(@PathVariable Integer id, @RequestBody PedidoDetalle datos) {
        return service.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}