package com.br.andersonrosa.microservicespringsecurity.infrastructure.usuario.jpa;

import com.br.andersonrosa.microservicespringsecurity.domain.usuario.data.UsuarioData;
import com.br.andersonrosa.microservicespringsecurity.domain.usuario.model.UsuarioOutput;
import com.br.andersonrosa.microservicespringsecurity.infrastructure.usuario.jpa.entity.Usuario;
import com.br.andersonrosa.microservicespringsecurity.infrastructure.usuario.jpa.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Esse clase será utilizada no caso de uso (Caso ela venha a existir heuheu)
 */
@AllArgsConstructor
@Component
public class UsuarioDataJpa implements UsuarioData {

    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioOutput getUsuario(String nome) {
        Optional<Usuario> usuarioOptional = this.usuarioRepository.findByLogin(nome);

        if(usuarioOptional.get() != null){

            Usuario usuario = usuarioOptional.get();

            return UsuarioOutput.builder()
                    .codigo(usuario.getId())
                    .habilitado(usuario.getHabilitado())
                    .login(usuario.getLogin())
                    .nome(usuario.getNome())
                    .build();
        }

        return new UsuarioOutput();
    }


}
