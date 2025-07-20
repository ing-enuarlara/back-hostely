package com.back.hostely.dto;

import com.back.hostely.model.FuncionFichaje;
import com.back.hostely.enums.EstadoFuncion;

import java.time.LocalTime;


public class FuncionFichajeDTO {
    private Integer id;
    private String nombre;
    private String descripcion;
    private EstadoFuncion estado;
    private LocalTime time;

    public FuncionFichajeDTO(FuncionFichaje f) {
        this.id = f.getId();
        this.nombre = f.getFuncion().getNombre();
        this.descripcion = f.getFuncion().getDescripcion();
        this.estado = f.getEstado();
        this.time = f.getTime();
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

    public EstadoFuncion getEstado() {
        return estado;
    }

    public void setEstado(EstadoFuncion estado) {
        this.estado = estado;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
