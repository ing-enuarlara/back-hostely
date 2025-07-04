package com.back.hostely.service;

import com.back.hostely.model.TPV;
import com.back.hostely.model.Sede;
import com.back.hostely.repository.TPVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TPVService {

    @Autowired
    private TPVRepository tpvRepository;

    public Optional<TPV> obtenerTPVActivo(Long tpvId) {
        return tpvRepository.findByIdAndActivaTrue(tpvId);
    }

    public Optional<TPV> obtenerTPVCodAcceso(String codAcceso) {
        return tpvRepository.findByClaveAcceso(codAcceso);
    }

    public Optional<TPV> obtenerSede(Sede sede) {
        return tpvRepository.findBySede(sede);
    }

    public TPV guardar(TPV tpv) {
        if (tpv.getClaveAcceso() != null && !tpv.getClaveAcceso().isBlank()) {
            tpv.setClaveAcceso(tpv.getClaveAcceso());
        }
        return tpvRepository.save(tpv);
    }

    public Optional<TPV> obtenerTPV(Long id) {
        return tpvRepository.findById(id);
    }

    public void eliminar(TPV tpv) {
        tpvRepository.delete(tpv);
    }
}