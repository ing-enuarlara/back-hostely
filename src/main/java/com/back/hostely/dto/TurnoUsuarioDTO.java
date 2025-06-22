package com.back.hostely.dto;

import java.sql.Date;
import java.sql.Time;

import com.back.hostely.enums.TurnoEstado;
import com.back.hostely.model.Turno;

public class TurnoUsuarioDTO {
    private String empleado;
    private Date fecha;
    private Time inicio;
    private Time fin;
    private String localNombre;
    private TurnoEstado estado;

    public TurnoUsuarioDTO(Turno turno) {
        this.empleado = turno.getUsuario().getNombre();
        this.fecha = turno.getFecha();
        this.inicio = turno.getInicio();
        this.fin = turno.getFin();
        this.localNombre = turno.getSede().getNombre();
        this.estado = turno.getEstado();
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getInicio() {
        return inicio;
    }

    public void setInicio(Time inicio) {
        this.inicio = inicio;
    }

    public Time getFin() {
        return fin;
    }

    public void setFin(Time fin) {
        this.fin = fin;
    }

    public String getLocalNombre() {
        return localNombre;
    }

    public void setLocalNombre(String localNombre) {
        this.localNombre = localNombre;
    }

    public TurnoEstado getEstado() {
        return estado;
    }

    public void setEstado(TurnoEstado estado) {
        this.estado = estado;
    }
}