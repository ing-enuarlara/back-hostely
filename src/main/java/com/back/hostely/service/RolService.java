package com.back.hostely.service;

import com.back.hostely.dto.RolDTO;
import com.back.hostely.model.Permiso;
import com.back.hostely.model.Rol;
import com.back.hostely.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.Optional;

@Service
public class RolService {

    @Autowired
    private RolRepository repository;

    @Autowired
    private PermisoService permisoService;

    public List<Rol> listarTodos() {
        return repository.findAll();
    }

    public Optional<Rol> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public List<Rol> buscarPorNegocio(Integer negocioId) {
        return repository.findByNegocioId(negocioId);
    }

    public Rol crearConPermisos(RolDTO dto) {
        Rol rol = new Rol();
        rol.setNombre(dto.getNombre());
        rol.setNegocioId(dto.getNegocioId());

        // Guardar primero para generar ID
        rol = repository.save(rol);

        if (dto.getPermisos() != null && !dto.getPermisos().isEmpty()) {
            Set<Permiso> permisos = permisoService.expandirConDependencias(
                    dto.getPermisos().stream().map(Integer::valueOf).toList());
            rol.setPermisos(permisos);
            rol = repository.save(rol);
        }

        return rol;
    }

    public Rol actualizar(Integer id, Rol datos) {
        return repository.findById(id).map(r -> {
            r.setNombre(datos.getNombre());
            if (r.getNegocioId() == null && datos.getNegocioId() != null) {
                r.setNegocioId(datos.getNegocioId());
            }
            return repository.save(r);
        }).orElseThrow(() -> new RuntimeException("Rol no encontrado"));
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    public List<Rol> buscarConGlobales(Integer negocioId) {
        List<Integer> idsGlobales = List.of(2, 3, 4);
        return repository.findByNegocioWithGlobal(negocioId, idsGlobales);
    }

    public void asignarPermisos(Integer rolId, List<Integer> permisoIds) {
        Rol rol = repository.findById(rolId)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        Set<Permiso> permisosExpandidos = permisoService.expandirConDependencias(
                permisoIds.stream().map(Integer::valueOf).toList());

        rol.setPermisos(permisosExpandidos);
        repository.save(rol);
    }
}