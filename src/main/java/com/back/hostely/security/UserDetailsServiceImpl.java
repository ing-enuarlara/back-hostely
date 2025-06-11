package com.back.hostely.security;

import com.back.hostely.model.Usuario;
import com.back.hostely.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

        @Autowired
        private UsuarioRepository usuarioRepository;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                Usuario usuario = usuarioRepository.findByEmail(username)
                                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

                List<SimpleGrantedAuthority> authorities = usuario.getRoles().stream()
                                .map(ur -> new SimpleGrantedAuthority("ROLE_" + ur.getRol().getNombre().toUpperCase()))
                                .toList();

                return new org.springframework.security.core.userdetails.User(
                                usuario.getEmail(),
                                usuario.getPasswordHash(),
                                authorities);
        }
}