package com.br.andersonrosa.microservicespringsecurity.infrastructure.usuario.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
@Builder
public class Usuario {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="id", updatable=false, nullable=false)
    @Type(type="org.hibernate.type.PostgresUUIDType")
    private UUID id;

    @Column(name="nome", nullable = false, length = 250)
    private String nome;

    @Column(name="login", nullable = false, length = 1000, unique = true)
    private String login;

    @Column(name="senha", nullable = false, length = 1000)
    private String senha;

    @Column(name="habilitado", nullable = false)
    private Boolean habilitado;
}
