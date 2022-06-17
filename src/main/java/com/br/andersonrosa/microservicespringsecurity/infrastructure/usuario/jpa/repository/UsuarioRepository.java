package com.br.andersonrosa.microservicespringsecurity.infrastructure.usuario.jpa.repository;

import com.br.andersonrosa.microservicespringsecurity.infrastructure.usuario.jpa.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    Optional<Usuario> findByLogin(String name);
}
