package com.back.hostely.dto;

public class TurnoSemanalDTO {
    private Integer id;
    private Integer sedeId;
    private String sedeNombre;
    private Integer puestoId;
    private String puestoNombre;
    private Integer usuarioId;
    private String usuarioNombre;
    private String fecha; // "yyyy-MM-dd"
    private String inicio; // "HH:mm"
    private String fin;
    private String estado;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getSedeId() {
        return sedeId;
    }
    public void setSedeId(Integer sedeId) {
        this.sedeId = sedeId;
    }
    public String getSedeNombre() {
        return sedeNombre;
    }
    public void setSedeNombre(String sedeNombre) {
        this.sedeNombre = sedeNombre;
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
    public Integer getUsuarioId() {
        return usuarioId;
    }
    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }
    public String getUsuarioNombre() {
        return usuarioNombre;
    }
    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getInicio() {
        return inicio;
    }
    public void setInicio(String inicio) {
        this.inicio = inicio;
    }
    public String getFin() {
        return fin;
    }
    public void setFin(String fin) {
        this.fin = fin;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
