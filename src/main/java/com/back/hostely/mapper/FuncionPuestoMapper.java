package com.back.hostely.mapper;

import com.back.hostely.dto.FuncionPuestoDTO;
import com.back.hostely.model.FuncionPuesto;
import com.back.hostely.model.Puesto;
import org.springframework.stereotype.Component;

@Component
public class FuncionPuestoMapper {

    public FuncionPuestoDTO toDTO(FuncionPuesto entity) {
        FuncionPuestoDTO dto = new FuncionPuestoDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setDescripcion(entity.getDescripcion());
        dto.setTime(entity.getTime());
        dto.setPuestoId(entity.getPuesto().getId());
        dto.setPuestoNombre(entity.getPuesto().getNombre());
        return dto;
    }

    public FuncionPuesto toEntity(FuncionPuestoDTO dto, Puesto puesto) {
        FuncionPuesto entity = new FuncionPuesto();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setDescripcion(dto.getDescripcion());
        entity.setTime(dto.getTime());
        entity.setPuesto(puesto);
        return entity;
    }
}