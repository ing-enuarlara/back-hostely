package com.back.hostely.dto;

public class HorarioDTO {
    private Integer id;
    private String inicio;
    private String fin;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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
}
