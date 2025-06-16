package com.back.hostely.service;

import com.back.hostely.model.Usuario;
import com.back.hostely.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    public Optional<Usuario> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public List<Usuario> buscarPorNombre(String nombre) {
        return repository.findByNombreContainingIgnoreCase(nombre);
    }

    public List<Usuario> buscarPorNegocio(Integer negocioId) {
        return repository.findByNegocioId(negocioId);
    }

    public Usuario crear(Usuario u) {
        return repository.save(u);
    }

    public Usuario actualizar(Integer id, Usuario datos) {
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

            return repository.save(u);
        }).orElse(null);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}