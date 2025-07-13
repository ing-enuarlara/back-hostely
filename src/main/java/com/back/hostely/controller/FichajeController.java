package com.back.hostely.controller;

import com.back.hostely.model.Fichaje;
import com.back.hostely.service.FichajeService;
import com.back.hostely.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/fichaje")
@CrossOrigin(origins = "*")
public class FichajeController {

    @Autowired
    private FichajeService service;

    @Autowired
    private TurnoService turnoService;

    @GetMapping
    public List<Fichaje> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Fichaje> porId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Fichaje> porUsuario(@PathVariable Integer usuarioId) {
        return service.buscarPorUsuario(usuarioId);
    }

    @GetMapping("/puesto/{puestoId}")
    public List<Fichaje> porPuesto(@PathVariable Integer puestoId) {
        return service.buscarPorPuesto(puestoId);
    }

    @GetMapping("/sede/{sedeId}")
    public List<Fichaje> porSede(@PathVariable Integer sedeId) {
        return service.buscarPorSede(sedeId);
    }

    @GetMapping("/negocio/{negocioId}")
    public List<Fichaje> porNegocio(@PathVariable Integer negocioId) {
        return service.buscarPorNegocio(negocioId);
    }

    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody Fichaje fichaje) {
        if (fichaje.getEnlace() != null && service.buscarPorEnlace(fichaje.getEnlace()).isPresent()) {
            return ResponseEntity.status(409).body("Este enlace de fichaje ya fue utilizado.");
        }

        Fichaje registrado = service.registrar(fichaje);
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime fechaParsed = LocalDateTime.parse(fichaje.getFecha(), formatter);
            Timestamp timestamp = Timestamp.valueOf(fechaParsed);

            turnoService.actualizarEstadoSiCoincideConFichaje( fichaje.getUsuarioId(), timestamp, fichaje.getTipo() );
        } catch (Exception e) {
            System.err.println("Error al parsear fecha de fichaje: " + e.getMessage());
        }
        return ResponseEntity.ok(registrado);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}