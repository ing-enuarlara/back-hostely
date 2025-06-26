package com.back.hostely.service;

import com.back.hostely.model.TPV;
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
}