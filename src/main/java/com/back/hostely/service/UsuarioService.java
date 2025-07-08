package com.back.hostely.service;

import com.back.hostely.dto.UsuarioRequestDTO;
import com.back.hostely.model.Rol;
import com.back.hostely.model.Sede;
import com.back.hostely.model.Usuario;
import com.back.hostely.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private RolService rolService;

    @Autowired
    private SedeService sedeService;

    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    public Optional<Usuario> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public List<Usuario> buscarUsuariosPorIds(List<Integer> ids) {
        return repository.findAllById(ids);
    }

    public List<Usuario> buscarPorNombre(String nombre) {
        return repository.findByNombreContainingIgnoreCase(nombre);
    }

    public List<Usuario> buscarPorNegocio(Integer negocioId) {
        return repository.findByNegocioId(negocioId);
    }

    public Usuario crear(UsuarioRequestDTO u) {
        Usuario usuario = new Usuario();

        usuario.setNombre(u.getNombre());
        usuario.setEdad(u.getEdad());
        usuario.setDireccion(u.getDireccion());
        usuario.setEmail(u.getEmail()); // ← FALTA ESTA LÍNEA EN TU ERROR
        usuario.setTelefono(u.getTelefono());
        usuario.setFotoPerfil(u.getFotoPerfil());
        usuario.setPasswordHash(u.getPasswordHash());
        usuario.setVerificado(u.getVerificado());
        usuario.setPaisId(u.getPaisId());
        usuario.setNegocioId(u.getNegocioId());

        // Guardar primero para generar ID
        usuario = repository.save(usuario);

        if (u.getRoles() != null && !u.getRoles().isEmpty()) {
            Set<Rol> roles = rolService.buscarPorIds(u.getRoles());
            usuario.setRoles(roles);
            usuario = repository.save(usuario);
        }

        if (u.getSedes() != null && !u.getSedes().isEmpty()) {
            Set<Sede> sedes = sedeService.buscarPorIds(u.getSedes());
            usuario.setSedes(sedes);
            usuario = repository.save(usuario);
        }

        return usuario;
    }

    public Usuario actualizar(Integer id, UsuarioRequestDTO datos) {
        return repository.findById(id).map(u -> {
            u.setNombre(datos.getNombre());
            u.setEdad(datos.getEdad());
            u.setEmail(datos.getEmail());
            u.setPaisId(datos.getPaisId());
            u.setDireccion(datos.getDireccion());
            u.setTelefono(datos.getTelefono());
            u.setEstadoSocial(datos.getEstadoSocial());
            u.setNegocioId(datos.getNegocioId());

            if (datos.getPasswordHash() != null && !datos.getPasswordHash().isBlank()) {
                u.setPasswordHash(datos.getPasswordHash());
            }

            if (datos.getFotoPerfil() != null && !datos.getFotoPerfil().isBlank()) {
                u.setFotoPerfil(datos.getFotoPerfil());
            }

            if (datos.getRoles() != null) {
                Set<Rol> roles = rolService.buscarPorIds(datos.getRoles());
                u.setRoles(roles);
            }

            if (datos.getSedes() != null) {
                Set<Sede> sedes = sedeService.buscarPorIds(datos.getSedes());
                u.setSedes(sedes);
            }

            return repository.save(u);
        }).orElse(null);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}