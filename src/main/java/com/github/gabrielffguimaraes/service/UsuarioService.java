package com.github.gabrielffguimaraes.service;

import com.github.gabrielffguimaraes.model.entity.Usuario;
import com.github.gabrielffguimaraes.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = this.usuarioRepository.findByUsername(username).
                orElseThrow(() -> new UsernameNotFoundException("Login não encontrado !"));
        return User.builder().
                username(usuario.getUsername()).
                password(usuario.getPassword()).
                roles("USER").
                build();
    }
}
