package com.back.hostely.service;

import com.back.hostely.model.UsuarioRol;
import com.back.hostely.repository.UsuarioRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioRolService {

    @Autowired
    private UsuarioRolRepository usuarioRolRepository;

    public List<UsuarioRol> findAll() {
        return usuarioRolRepository.findAll();
    }

    public List<UsuarioRol> findByUsuarioId(Long usuarioId) {
        return usuarioRolRepository.findByUsuarioId(usuarioId);
    }

    public UsuarioRol save(UsuarioRol usuarioRol) {
        return usuarioRolRepository.save(usuarioRol);
    }

    public void deleteById(Long id) {
        usuarioRolRepository.deleteById(id);
    }
}