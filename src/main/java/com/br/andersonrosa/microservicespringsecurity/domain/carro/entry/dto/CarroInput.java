package com.br.andersonrosa.microservicespringsecurity.domain.carro.entry.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarroInput {

    private String nome;
    private String marca;

}
