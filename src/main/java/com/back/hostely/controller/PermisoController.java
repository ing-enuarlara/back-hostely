package com.back.hostely.controller;

import com.back.hostely.dto.PermisoDTO;
import com.back.hostely.service.PermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permisos")
public class PermisoController {

    @Autowired
    private PermisoService permisoService;

    @GetMapping
    public List<PermisoDTO> listarTodos() {
        return permisoService.listarTodos();
    }

    @PostMapping
    public PermisoDTO crear(@RequestBody PermisoDTO permisoDTO) {
        return permisoService.guardar(permisoDTO);
    }

    @PutMapping("/{id}")
    public PermisoDTO actualizar(@PathVariable Integer id, @RequestBody PermisoDTO permisoDTO) {
        return permisoService.actualizar(id, permisoDTO);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        permisoService.eliminar(id);
    }
}