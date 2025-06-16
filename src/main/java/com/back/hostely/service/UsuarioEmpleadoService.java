package com.back.hostely.service;

import com.back.hostely.model.UsuarioEmpleado;
import com.back.hostely.repository.UsuarioEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioEmpleadoService {

    @Autowired
    private UsuarioEmpleadoRepository repository;

    public List<UsuarioEmpleado> listarTodos() {
        return repository.findAll();
    }

    public Optional<UsuarioEmpleado> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public List<UsuarioEmpleado> buscarPorUsuario(Integer usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }

    public UsuarioEmpleado crear(UsuarioEmpleado relacion) {
        return repository.save(relacion);
    }

    public UsuarioEmpleado actualizar(Integer id, UsuarioEmpleado datos) {
        return repository.findById(id).map(r -> {
            if (datos.getUsuarioId() != null)
                r.setUsuarioId(datos.getUsuarioId());
            if (datos.getDisponibilidad() != null)
                r.setDisponibilidad(datos.getDisponibilidad());
            if (datos.getEstado() != null)
                r.setEstado(datos.getEstado());
            if (datos.getTransportePropio() != null)
                r.setTransportePropio(datos.getTransportePropio());
            return repository.save(r);
        }).orElse(null);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}