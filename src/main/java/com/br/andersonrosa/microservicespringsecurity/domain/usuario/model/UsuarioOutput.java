package com.br.andersonrosa.microservicespringsecurity.domain.usuario.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioOutput {

    private UUID codigo;
    private String nome;
    private String login;
    private String senha;
    private Boolean habilitado;
}
