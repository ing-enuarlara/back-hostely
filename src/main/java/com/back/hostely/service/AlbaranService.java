package com.back.hostely.service;

import com.back.hostely.model.Albaran;
import com.back.hostely.repository.AlbaranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbaranService {

    @Autowired
    private AlbaranRepository repository;

    public List<Albaran> listarTodos() {
        return repository.findAll();
    }

    public Optional<Albaran> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public List<Albaran> buscarPorSede(Integer sedeId) {
        return repository.findBySedeId(sedeId);
    }

    public List<Albaran> buscarPorUsuario(Integer usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }

    public Albaran crear(Albaran a) {
        return repository.save(a);
    }

    public Albaran actualizar(Integer id, Albaran datos) {
        return repository.findById(id).map(a -> {
            a.setSedeId(datos.getSedeId());
            a.setUsuarioId(datos.getUsuarioId());
            a.setFecha(datos.getFecha());
            a.setObservaciones(datos.getObservaciones());
            return repository.save(a);
        }).orElse(null);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}