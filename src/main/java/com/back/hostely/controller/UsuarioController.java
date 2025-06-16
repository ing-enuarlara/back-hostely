package com.back.hostely.controller;

import com.back.hostely.model.Usuario;
import com.back.hostely.service.UsuarioService;
import com.back.hostely.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private S3Service s3Service;

    @GetMapping
    public List<Usuario> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> porId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/buscar")
    public List<Usuario> porNombre(@RequestParam String nombre) {
        return service.buscarPorNombre(nombre);
    }

    @GetMapping("/negocio/{negocioId}")
    public List<Usuario> porNegocio(@PathVariable Integer negocioId) {
        return service.buscarPorNegocio(negocioId);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Usuario crear(@RequestPart("usuario") Usuario u,
            @RequestPart(value = "fotoPerfil", required = false) MultipartFile fotoPerfil) throws IOException {

        if (fotoPerfil != null && !fotoPerfil.isEmpty()) {
            String url = s3Service.uploadFile(fotoPerfil);
            u.setFotoPerfil(url);
        }

        if (u.getPasswordHash() != null && !u.getPasswordHash().isBlank()) {
            u.setPasswordHash(passwordEncoder.encode(u.getPasswordHash()));
        }

        return service.crear(u);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Usuario actualizar(@PathVariable Integer id,
            @RequestPart("usuario") Usuario datos,
            @RequestPart(value = "fotoPerfil", required = false) MultipartFile fotoPerfil) throws IOException {

        if (fotoPerfil != null && !fotoPerfil.isEmpty()) {
            String url = s3Service.uploadFile(fotoPerfil);
            datos.setFotoPerfil(url);
        }

        if (datos.getPasswordHash() != null && !datos.getPasswordHash().isBlank()) {
            datos.setPasswordHash(passwordEncoder.encode(datos.getPasswordHash()));
        }

        return service.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}