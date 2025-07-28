package com.back.hostely.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.back.hostely.model.Puesto;

public class PuestoDTO {
    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer negocioId;

    private List<HorarioPuestoDTO> horarios;

    public PuestoDTO() {}

    public PuestoDTO(Puesto p) {
        this.id = p.getId();
        this.nombre = p.getNombre();
        this.descripcion = p.getDescripcion();
        this.negocioId = p.getNegocioId();

        // Mapear objetos completos
        this.horarios = p.getHorarios() != null
            ? p.getHorarios().stream().map(HorarioPuestoDTO::new).collect(Collectors.toList())
            : List.of();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getNegocioId() {
        return negocioId;
    }

    public void setNegocioId(Integer negocioId) {
        this.negocioId = negocioId;
    }

    public List<HorarioPuestoDTO> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<HorarioPuestoDTO> horarios) {
        this.horarios = horarios;
    }
}