package com.back.hostely.dto;

import com.back.hostely.enums.TurnoEstado;

import java.sql.Date;
import java.sql.Time;

public class TurnoListadoDTO {
    private Integer id;
    private Date fecha;
    private Time inicio;
    private Time fin;
    private TurnoEstado estado;
    private String usuarioNombre;
    private String usuarioFoto;
    private Integer usuarioRolId;
    private String usuarioRolNombre;
    private String localNombre;

    public TurnoListadoDTO() {
    }

    public TurnoListadoDTO(com.back.hostely.model.Turno turno) {
        this.id = turno.getId();
        this.fecha = turno.getFecha();
        this.inicio = turno.getInicio();
        this.fin = turno.getFin();
        this.estado = turno.getEstado();
        this.localNombre = turno.getSede().getNombre();

        if (turno.getUsuario() != null) {
            this.usuarioNombre = turno.getUsuario().getNombre();
            this.usuarioFoto = turno.getUsuario().getFotoPerfil();
            if (turno.getUsuario().getRolPrincipal() != null) {
                this.usuarioRolId = turno.getUsuario().getRolPrincipal().getId();
                this.usuarioRolNombre = turno.getUsuario().getRolPrincipal().getNombre();
            }
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public TurnoEstado getEstado() {
        return estado;
    }

    public void setEstado(TurnoEstado estado) {
        this.estado = estado;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public String getLocalNombre() {
        return localNombre;
    }

    public void setLocalNombre(String localNombre) {
        this.localNombre = localNombre;
    }

    public String getUsuarioFoto() {
        return usuarioFoto;
    }

    public void setUsuarioFoto(String usuarioFoto) {
        this.usuarioFoto = usuarioFoto;
    }

    public Integer getUsuarioRolId() {
        return usuarioRolId;
    }

    public void setUsuarioRolId(Integer usuarioRolId) {
        this.usuarioRolId = usuarioRolId;
    }

    public String getUsuarioRolNombre() {
        return usuarioRolNombre;
    }

    public void setUsuarioRolNombre(String usuarioRolNombre) {
        this.usuarioRolNombre = usuarioRolNombre;
    }
}