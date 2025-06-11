package com.back.hostely.service;

import com.back.hostely.model.UsuarioSede;
import com.back.hostely.repository.UsuarioSedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioSedeService {

    @Autowired
    private UsuarioSedeRepository usuarioSedeRepository;

    public List<UsuarioSede> findAll() {
        return usuarioSedeRepository.findAll();
    }

    public List<UsuarioSede> findByUsuarioId(Long usuarioId) {
        return usuarioSedeRepository.findByUsuarioId(usuarioId);
    }

    public UsuarioSede save(UsuarioSede usuarioSede) {
        return usuarioSedeRepository.save(usuarioSede);
    }

    public void deleteById(Long id) {
        usuarioSedeRepository.deleteById(id);
    }
}