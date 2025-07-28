package com.back.hostely.dto;

import java.util.List;

public class PlanningDTO {
    private List<PuestoPlanningDTO> puestos;
    private List<TurnoSemanalDTO> turnos;
    
    public List<PuestoPlanningDTO> getPuestos() {
        return puestos;
    }
    public void setPuestos(List<PuestoPlanningDTO> puestos) {
        this.puestos = puestos;
    }
    public List<TurnoSemanalDTO> getTurnos() {
        return turnos;
    }
    public void setTurnos(List<TurnoSemanalDTO> turnos) {
        this.turnos = turnos;
    }
}
