package com.back.hostely.security;

import com.back.hostely.model.Usuario;
import com.back.hostely.model.UsuarioRol;
import com.back.hostely.repository.UsuarioRepository;
import com.back.hostely.repository.UsuarioRolRepository;
import com.back.hostely.repository.RolRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

        @Autowired
        private UsuarioRepository usuarioRepository;

        @Autowired
        private UsuarioRolRepository usuarioRolRepository;

        @Autowired
        private RolRepository rolRepository;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                Usuario usuario = usuarioRepository.findByEmail(username)
                                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

                List<UsuarioRol> usuarioRoles = usuarioRolRepository.findByUsuarioId(usuario.getId());

                List<SimpleGrantedAuthority> authorities = usuarioRoles.stream()
                                .map(ur -> rolRepository.findById(ur.getRolId()).orElse(null))
                                .filter(Objects::nonNull)
                                .map(rol -> new SimpleGrantedAuthority("ROLE_" + rol.getNombre().toUpperCase()))
                                .collect(Collectors.toList());

                return new org.springframework.security.core.userdetails.User(
                                usuario.getEmail(),
                                usuario.getPasswordHash(),
                                authorities);
        }
}