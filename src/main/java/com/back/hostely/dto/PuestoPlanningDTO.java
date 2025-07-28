package com.back.hostely.dto;

import java.util.List;

public class PuestoPlanningDTO {
    private Integer id;
    private String nombre;
    private List<HorarioDTO> horarios;

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
    public List<HorarioDTO> getHorarios() {
        return horarios;
    }
    public void setHorarios(List<HorarioDTO> horarios) {
        this.horarios = horarios;
    }
}