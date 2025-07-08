package com.back.hostely.service;

import com.back.hostely.dto.PermisoDTO;
import com.back.hostely.model.Permiso;
import com.back.hostely.model.PermisoDependencia;
import com.back.hostely.repository.PermisoDependenciaRepository;
import com.back.hostely.repository.PermisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Queue;
import java.util.stream.Collectors;

@Service
public class PermisoService {

    @Autowired
    private PermisoRepository permisoRepository;

    @Autowired
    private PermisoDependenciaRepository permisoDependenciaRepository;

    public List<PermisoDTO> listarTodos() {
        return permisoRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public PermisoDTO guardar(PermisoDTO dto) {
        Permiso permiso = new Permiso();
        permiso.setNombre(dto.getNombre());
        permiso.setDescripcion(dto.getDescripcion());
        permiso = permisoRepository.save(permiso);
        return toDTO(permiso);
    }

    public PermisoDTO actualizar(Integer id, PermisoDTO dto) {
        Permiso permiso = permisoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Permiso no encontrado"));
        permiso.setNombre(dto.getNombre());
        permiso.setDescripcion(dto.getDescripcion());
        return toDTO(permisoRepository.save(permiso));
    }

    public void eliminar(Integer id) {
        permisoRepository.deleteById(id);
    }

    private PermisoDTO toDTO(Permiso permiso) {
        PermisoDTO dto = new PermisoDTO();
        dto.setId(permiso.getId());
        dto.setNombre(permiso.getNombre());
        dto.setDescripcion(permiso.getDescripcion());
        return dto;
    }

    public Set<Permiso> expandirConDependencias(List<Integer> idsIniciales) {
        Set<Permiso> resultado = new HashSet<>(permisoRepository.findAllById(idsIniciales));

        Queue<Permiso> pendientes = new LinkedList<>(resultado);

        while (!pendientes.isEmpty()) {
            Permiso actual = pendientes.poll();
            List<PermisoDependencia> deps = permisoDependenciaRepository.findByPermiso(actual);
            for (PermisoDependencia dep : deps) {
                if (resultado.add(dep.getDependeDe())) {
                    pendientes.add(dep.getDependeDe());
                }
            }
        }

        return resultado;
    }
}