package com.back.hostely.dto;

import com.back.hostely.enums.Estado;
import com.back.hostely.model.TPV;

public class TPVDTO {
    private Long id;
    private String nombre;
    private Integer sedeId;
    private String claveAcceso;
    private Estado activa;

    public TPVDTO() {}

    public TPVDTO(TPV tpv) {
        this.id = tpv.getId();
        this.nombre = tpv.getNombre();
        this.sedeId = tpv.getSede().getId();
        this.claveAcceso = tpv.getClaveAcceso();
        this.activa = tpv.getActiva();
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public Integer getSedeId() { return sedeId; }
    public String getClaveAcceso() { return claveAcceso; }
    public Estado getActiva() { return activa; }
}