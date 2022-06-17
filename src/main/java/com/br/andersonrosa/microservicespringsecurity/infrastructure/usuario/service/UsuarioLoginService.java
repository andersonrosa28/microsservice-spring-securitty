package com.br.andersonrosa.microservicespringsecurity.infrastructure.usuario.service;

import com.br.andersonrosa.microservicespringsecurity.infrastructure.usuario.jpa.entity.Usuario;
import com.br.andersonrosa.microservicespringsecurity.infrastructure.usuario.jpa.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioLoginService implements UserDetailsService {

    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {

        Optional<Usuario> usuario = usuarioRepository.findByLogin(username);
        if(usuario == null || usuario.get() == null) {
            return null;
        }

        String[] rolesUser = {"USER"};

        List<GrantedAuthority> auth = AuthorityUtils.createAuthorityList(rolesUser);
        return new User(usuario.get().getLogin(), usuario.get().getSenha(), auth);
    }

}
