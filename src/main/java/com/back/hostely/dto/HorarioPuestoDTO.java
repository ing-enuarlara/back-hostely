package com.back.hostely.dto;

import java.time.LocalTime;

public class HorarioPuestoDTO {
    private Integer id;
    private LocalTime timeInicio;
    private LocalTime timeFin;
    private Integer puestoId;
    private String puestoNombre;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalTime getTimeInicio() {
        return timeInicio;
    }

    public void setTimeInicio(LocalTime timeInicio) {
        this.timeInicio = timeInicio;
    }

    public LocalTime getTimeFin() {
        return timeFin;
    }

    public void setTimeFin(LocalTime timeFin) {
        this.timeFin = timeFin;
    }

    public Integer getPuestoId() {
        return puestoId;
    }

    public void setPuestoId(Integer puestoId) {
        this.puestoId = puestoId;
    }

    public String getPuestoNombre() {
        return puestoNombre;
    }

    public void setPuestoNombre(String puestoNombre) {
        this.puestoNombre = puestoNombre;
    }
}