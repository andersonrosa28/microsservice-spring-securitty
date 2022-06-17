package com.br.andersonrosa.microservicespringsecurity.domain.usuario.data;

import com.br.andersonrosa.microservicespringsecurity.domain.usuario.model.UsuarioOutput;

public interface UsuarioData {
    UsuarioOutput getUsuario(String nome);
}
