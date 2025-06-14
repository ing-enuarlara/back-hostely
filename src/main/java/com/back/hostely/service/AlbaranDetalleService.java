package com.back.hostely.service;

import com.back.hostely.model.AlbaranDetalle;
import com.back.hostely.repository.AlbaranDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbaranDetalleService {

    @Autowired
    private AlbaranDetalleRepository repository;

    public List<AlbaranDetalle> listarTodos() {
        return repository.findAll();
    }

    public Optional<AlbaranDetalle> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public List<AlbaranDetalle> buscarPorAlbaran(Integer albaranId) {
        return repository.findByAlbaranId(albaranId);
    }

    public AlbaranDetalle crear(AlbaranDetalle d) {
        return repository.save(d);
    }

    public AlbaranDetalle actualizar(Integer id, AlbaranDetalle datos) {
        return repository.findById(id).map(det -> {
            det.setAlbaranId(datos.getAlbaranId());
            det.setInsumoId(datos.getInsumoId());
            det.setCantidad(datos.getCantidad());
            return repository.save(det);
        }).orElse(null);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}