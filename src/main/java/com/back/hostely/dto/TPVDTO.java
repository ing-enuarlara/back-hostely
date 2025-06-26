package com.back.hostely.dto;

import com.back.hostely.model.TPV;

public class TPVDTO {
    private Long id;
    private String nombre;
    private Integer sedeId;

    public TPVDTO(TPV tpv) {
        this.id = tpv.getId();
        this.nombre = tpv.getNombre();
        this.sedeId = tpv.getSede().getId();
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public Integer getSedeId() { return sedeId; }
}