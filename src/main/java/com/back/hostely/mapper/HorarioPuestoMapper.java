package com.back.hostely.mapper;

import com.back.hostely.dto.HorarioPuestoDTO;
import com.back.hostely.model.HorarioPuesto;
import com.back.hostely.model.Puesto;
import org.springframework.stereotype.Component;

@Component
public class HorarioPuestoMapper {

    public HorarioPuestoDTO toDTO(HorarioPuesto entity) {
        HorarioPuestoDTO dto = new HorarioPuestoDTO();
        dto.setId(entity.getId());
        dto.setTimeInicio(entity.getTimeInicio());
        dto.setTimeFin(entity.getTimeFin());
        dto.setPuestoId(entity.getPuesto().getId());
        dto.setPuestoNombre(entity.getPuesto().getNombre());
        return dto;
    }

    public HorarioPuesto toEntity(HorarioPuestoDTO dto, Puesto puesto) {
        HorarioPuesto entity = new HorarioPuesto();
        entity.setId(dto.getId());
        entity.setTimeInicio(dto.getTimeInicio());
        entity.setTimeFin(dto.getTimeFin());
        entity.setPuesto(puesto);
        return entity;
    }
}