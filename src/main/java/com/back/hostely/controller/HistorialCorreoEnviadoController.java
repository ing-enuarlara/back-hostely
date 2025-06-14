package com.back.hostely.controller;

import com.back.hostely.model.HistorialCorreoEnviado;
import com.back.hostely.service.HistorialCorreoEnviadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/historial-correos")
@CrossOrigin(origins = "*")
public class HistorialCorreoEnviadoController {

    @Autowired
    private HistorialCorreoEnviadoService service;

    @GetMapping
    public List<HistorialCorreoEnviado> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<HistorialCorreoEnviado> porId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/remitente/{remitenteId}")
    public List<HistorialCorreoEnviado> porRemitente(@PathVariable Integer remitenteId) {
        return service.buscarPorRemitente(remitenteId);
    }

    @GetMapping("/destinatario/{destinatarioId}")
    public List<HistorialCorreoEnviado> porDestinatario(@PathVariable Integer destinatarioId) {
        return service.buscarPorDestinatario(destinatarioId);
    }

    @GetMapping("/negocio/{negocioId}")
    public List<HistorialCorreoEnviado> porNegocio(@PathVariable Integer negocioId) {
        return service.buscarPorNegocio(negocioId);
    }
}