package com.br.andersonrosa.microservicespringsecurity.domain.carro.entry.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarroOutput {

    private String nome;
    private String marca;

}
