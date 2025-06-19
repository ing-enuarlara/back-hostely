package com.back.hostely.controller;

import com.back.hostely.dto.EmpleadoDTO;
import com.back.hostely.dto.UsuarioLoginDTO;
import com.back.hostely.model.Negocio;
import com.back.hostely.model.Usuario;
import com.back.hostely.model.UsuarioEmpleado;
import com.back.hostely.model.UsuarioRol;
import com.back.hostely.repository.NegocioRepository;
import com.back.hostely.repository.RolRepository;
import com.back.hostely.repository.UsuarioRepository;
import com.back.hostely.repository.UsuarioRolRepository;
import com.back.hostely.repository.UsuarioEmpleadoRepository;
import com.back.hostely.security.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.back.hostely.service.S3Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private NegocioRepository negocioRepository;

    @Autowired
    private UsuarioRolRepository usuarioRolRepository;

    @Autowired
    private UsuarioEmpleadoRepository usuarioEmpleadoRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private S3Service s3Service;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid Usuario usuario) {
        Optional<Usuario> existingUser = usuarioRepository.findByEmail(usuario.getEmail());
        if (existingUser.isPresent()) {
            return ResponseEntity.badRequest().body("El correo ya está registrado");
        }

        Negocio negocio = new Negocio();
        negocio.setEmail(usuario.getEmail());
        negocio.setPais(usuario.getPaisId());
        negocio.setTipo(2);
        negocioRepository.save(negocio);

        usuario.setNegocioId(negocio.getId());
        usuario.setPasswordHash(passwordEncoder.encode(usuario.getPasswordHash()));
        Usuario usuarioGuardado = usuarioRepository.save(usuario);

        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuarioId(usuarioGuardado.getId());
        usuarioRol.setRolId(2);
        usuarioRol.setPrincipal("SI");
        usuarioRolRepository.save(usuarioRol);

        return ResponseEntity.ok("Usuario registrado con éxito");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.get("email"),
                            loginRequest.get("password")));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }

        Usuario usuario = usuarioRepository.findByEmail(loginRequest.get("email")).orElse(null);
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario no encontrado");
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.get("email"));
        String token = jwtUtil.generateToken(userDetails);

        Optional<Negocio> negocioOpt = negocioRepository.findById(usuario.getNegocioId());
        List<UsuarioRol> rolesUsuario = usuarioRolRepository.findByUsuarioId(usuario.getId());

        List<Map<String, Object>> roles = new ArrayList<>();
        for (UsuarioRol ur : rolesUsuario) {
            rolRepository.findById(ur.getRolId()).ifPresent(rol -> {
                Map<String, Object> rolMap = new HashMap<>();
                rolMap.put("id", rol.getId());
                rolMap.put("nombre", rol.getNombre());
                rolMap.put("principal", ur.getPrincipal());
                roles.add(rolMap);
            });
        }

        UsuarioLoginDTO usuarioDTO = new UsuarioLoginDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setFotoPerfil(usuario.getFotoPerfil());
        usuarioDTO.setNegocioId(usuario.getNegocioId());
        usuarioDTO.setVerificado(usuario.getVerificado());

        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("usuario", usuarioDTO);
        response.put("negocio", negocioOpt.orElse(null));
        response.put("roles", roles);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/registerEmpleado", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> registerEmpleado(
            @RequestPart("empleado") @Valid EmpleadoDTO dto,
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
        usuario.setVerificado("NO");

        if (fotoPerfil != null && !fotoPerfil.isEmpty()) {
            String url = s3Service.uploadFile(fotoPerfil, "perfil");
            usuario.setFotoPerfil(url);
        }

        Usuario usuarioGuardado = usuarioRepository.save(usuario);

        // Guardar en UsuarioEmpleado
        UsuarioEmpleado usuarioEmpleado = new UsuarioEmpleado();
        usuarioEmpleado.setUsuarioId(usuarioGuardado.getId());
        usuarioEmpleado.setDisponibilidad(dto.getDisponibilidad());
        usuarioEmpleado.setEstado("ACTIVO");
        usuarioEmpleado.setTransportePropio(dto.getTransportePropio());
        usuarioEmpleadoRepository.save(usuarioEmpleado);

        // Asignar rol EMPLEADO (ID = 4)
        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuarioId(usuarioGuardado.getId());
        usuarioRol.setRolId(4);
        usuarioRol.setPrincipal("SI");
        usuarioRolRepository.save(usuarioRol);

        return ResponseEntity.ok("Empleado registrado con éxito");
    }
}