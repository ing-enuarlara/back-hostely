package com.back.hostely.controller;

import com.back.hostely.model.UsuarioEmpleado;
import com.back.hostely.model.Usuario;
import com.back.hostely.model.UsuarioRol;
import com.back.hostely.repository.RolRepository;
import com.back.hostely.repository.UsuarioEmpleadoRepository;
import com.back.hostely.repository.UsuarioRepository;
import com.back.hostely.repository.UsuarioRolRepository;
import com.back.hostely.dto.EmpleadoDTO;
import com.back.hostely.dto.EmpleadoListDTO;
import com.back.hostely.dto.EmpleadoUpdateDTO;
import com.back.hostely.service.S3Service;
import com.back.hostely.dto.RolDTO;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioEmpleadoRepository usuarioEmpleadoRepository;

    @Autowired
    private UsuarioRolRepository usuarioRolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private S3Service s3Service;

    @Autowired
    private RolRepository rolRepository;

    @GetMapping("/listar/{negocioId}")
    public List<EmpleadoListDTO> listarPorNegocio(@PathVariable Integer negocioId) {
        List<UsuarioRol> rolesEmpleado = usuarioRolRepository.findByRolId(4); // solo empleados

        List<EmpleadoListDTO> empleados = new ArrayList<>();

        for (UsuarioRol ur : rolesEmpleado) {
            Optional<Usuario> optUsuario = usuarioRepository.findById(ur.getUsuarioId());
            if (optUsuario.isPresent()) {
                Usuario u = optUsuario.get();
                if (!u.getNegocioId().equals(negocioId))
                    continue;

                EmpleadoListDTO dto = new EmpleadoListDTO();
                dto.setId(u.getId());
                dto.setNombre(u.getNombre());
                dto.setEdad(u.getEdad());
                dto.setDireccion(u.getDireccion());
                dto.setEstadoSocial(u.getEstadoSocial());
                dto.setEmail(u.getEmail());
                dto.setTelefono(u.getTelefono());
                dto.setNegocioId(u.getNegocioId());
                dto.setPaisId(u.getPaisId());
                dto.setPasswordHash(u.getPasswordHash());
                dto.setFotoPerfil(u.getFotoPerfil());
                dto.setVerificado(u.getVerificado());
                dto.setCreadoEn(u.getCreadoEn());

                // datos de usuario_empleado
                List<UsuarioEmpleado> rel = usuarioEmpleadoRepository.findByUsuarioId(u.getId());
                if (!rel.isEmpty()) {
                    UsuarioEmpleado ue = rel.get(0);
                    dto.setEstado(ue.getEstado());
                    dto.setDisponibilidad(ue.getDisponibilidad());
                    dto.setTransportePropio(ue.getTransportePropio());
                }

                List<UsuarioRol> rolesDelUsuario = usuarioRolRepository.findByUsuarioId(u.getId());
                List<RolDTO> rolesDTO = new ArrayList<>();
                for (UsuarioRol r : rolesDelUsuario) {
                    rolRepository.findById(r.getRolId()).ifPresent(rol -> {
                        rolesDTO.add(new RolDTO(rol.getId(), rol.getNombre()));
                    });
                }
                dto.setRoles(rolesDTO);

                empleados.add(dto);
            }
        }

        return empleados;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerEmpleadoPorId(@PathVariable Integer id) {
        Optional<Usuario> optUsuario = usuarioRepository.findById(id);
        if (optUsuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empleado no encontrado");
        }

        Usuario u = optUsuario.get();
        EmpleadoListDTO dto = new EmpleadoListDTO();

        dto.setId(u.getId());
        dto.setNombre(u.getNombre());
        dto.setEdad(u.getEdad());
        dto.setDireccion(u.getDireccion());
        dto.setEstadoSocial(u.getEstadoSocial());
        dto.setEmail(u.getEmail());
        dto.setTelefono(u.getTelefono());
        dto.setNegocioId(u.getNegocioId());
        dto.setPaisId(u.getPaisId());
        dto.setPasswordHash(u.getPasswordHash());
        dto.setFotoPerfil(u.getFotoPerfil());
        dto.setVerificado(u.getVerificado());
        dto.setCreadoEn(u.getCreadoEn());
        dto.setPuesto("Cocinero"); // temporal o real si tienes ese dato
        dto.setFechaContratacion(u.getCreadoEn()); // puedes sacar esto de `creadoEn` si no tienes otra
        dto.setNumeroEmpleado("10000"+u.getId()); // puedes generar uno temporal como "10000" + id
        dto.setTipoContrato("Full-time"); // puedes guardar este dato en UsuarioEmpleado
        dto.setRating(4.2); // por ahora puedes simularlo
        dto.setHorasTrabajadas(1396); // simulación también
        dto.setDiasLibres(5); // simulación

        List<UsuarioEmpleado> rel = usuarioEmpleadoRepository.findByUsuarioId(u.getId());
        if (!rel.isEmpty()) {
            UsuarioEmpleado ue = rel.get(0);
            dto.setEstado(ue.getEstado());
            dto.setDisponibilidad(ue.getDisponibilidad());
            dto.setTransportePropio(ue.getTransportePropio());
        }

        List<UsuarioRol> rolesDelUsuario = usuarioRolRepository.findByUsuarioId(u.getId());
        List<RolDTO> rolesDTO = new ArrayList<>();
        for (UsuarioRol r : rolesDelUsuario) {
            rolRepository.findById(r.getRolId()).ifPresent(rol -> {
                rolesDTO.add(new RolDTO(rol.getId(), rol.getNombre()));
            });
        }
        dto.setRoles(rolesDTO);

        return ResponseEntity.ok(dto);
    }

    @PostMapping(value = "/crear", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> register(@RequestPart("empleado") @Valid EmpleadoDTO dto,
            @RequestPart(value = "fotoPerfil", required = false) MultipartFile fotoPerfil) throws IOException {
        Optional<Usuario> existingUser = usuarioRepository.findByEmail(dto.getEmail());
        if (existingUser.isPresent()) {
            return ResponseEntity.badRequest().body("El correo ya está registrado");
        }

        // Crear y guardar el Usuario
        Usuario usuario = new Usuario();
        usuario.setNombre(dto.getNombre());
        usuario.setEdad(dto.getEdad());
        usuario.setDireccion(dto.getDireccion());
        usuario.setEstadoSocial(dto.getEstadoSocial());
        usuario.setEmail(dto.getEmail());
        usuario.setTelefono(dto.getTelefono());
        usuario.setPasswordHash(passwordEncoder.encode(dto.getPasswordHash()));
        usuario.setPaisId(dto.getPaisId());
        usuario.setNegocioId(dto.getNegocioId());
        usuario.setVerificado(dto.getVerificado());

        if (fotoPerfil != null && !fotoPerfil.isEmpty()) {
            String url = s3Service.uploadFile(fotoPerfil, "perfil");
            usuario.setFotoPerfil(url);
        }

        Usuario usuarioGuardado = usuarioRepository.save(usuario);

        // Crear y guardar UsuarioEmpleado
        UsuarioEmpleado usuarioEmpleado = new UsuarioEmpleado();
        usuarioEmpleado.setUsuarioId(usuarioGuardado.getId());
        usuarioEmpleado.setDisponibilidad(dto.getDisponibilidad());
        usuarioEmpleado.setEstado("ACTIVO");
        usuarioEmpleado.setTransportePropio(dto.getTransportePropio());
        usuarioEmpleadoRepository.save(usuarioEmpleado);

        // Registrar rol
        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuarioId(usuarioGuardado.getId());
        usuarioRol.setRolId(4);
        usuarioRol.setPrincipal("SI");
        usuarioRolRepository.save(usuarioRol);

        return ResponseEntity.ok("Empleado registrado con éxito");
    }

    @PutMapping(value = "/editar/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> editarEmpleado(@PathVariable Integer id,
            @RequestPart("empleado") EmpleadoUpdateDTO dto,
            @RequestPart(value = "fotoPerfil", required = false) MultipartFile fotoPerfil) throws IOException {
        Optional<Usuario> optUsuario = usuarioRepository.findById(id);
        if (optUsuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }

        Usuario usuario = optUsuario.get();

        if (dto.getNombre() != null)
            usuario.setNombre(dto.getNombre());
        if (dto.getEmail() != null)
            usuario.setEmail(dto.getEmail());
        if (dto.getTelefono() != null)
            usuario.setTelefono(dto.getTelefono());
        if (dto.getPaisId() != null)
            usuario.setPaisId(dto.getPaisId());
        if (dto.getNegocioId() != null)
            usuario.setNegocioId(dto.getNegocioId());
        if (dto.getPasswordHash() != null && !dto.getPasswordHash().isBlank()) {
            usuario.setPasswordHash(passwordEncoder.encode(dto.getPasswordHash()));
        }

        if (fotoPerfil != null && !fotoPerfil.isEmpty()) {
            String url = s3Service.uploadFile(fotoPerfil, "perfil");
            usuario.setFotoPerfil(url);
        }

        usuarioRepository.save(usuario);

        List<UsuarioEmpleado> empleados = usuarioEmpleadoRepository.findByUsuarioId(id);
        if (!empleados.isEmpty()) {
            UsuarioEmpleado empleado = empleados.get(0);
            if (dto.getDisponibilidad() != null)
                empleado.setDisponibilidad(dto.getDisponibilidad());
            if (dto.getEstado() != null)
                empleado.setEstado(dto.getEstado());
            if (dto.getTransportePropio() != null)
                empleado.setTransportePropio(dto.getTransportePropio());
            usuarioEmpleadoRepository.save(empleado);
        }

        return ResponseEntity.ok("Empleado actualizado con éxito");
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarEmpleado(@PathVariable Integer id) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empleado no encontrado");
        }

        Usuario usuario = usuarioOpt.get();

        if (usuario.getFotoPerfil() != null && !usuario.getFotoPerfil().isBlank()) {
            s3Service.deleteFileFromUrl(usuario.getFotoPerfil());
        }

        List<UsuarioRol> roles = usuarioRolRepository.findByUsuarioId(id);
        usuarioRolRepository.deleteAll(roles);

        List<UsuarioEmpleado> relacionesEmpleado = usuarioEmpleadoRepository.findByUsuarioId(id);
        usuarioEmpleadoRepository.deleteAll(relacionesEmpleado);

        usuarioRepository.deleteById(id);

        return ResponseEntity.ok("Empleado eliminado con éxito");
    }
}