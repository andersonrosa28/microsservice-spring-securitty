package com.br.andersonrosa.microservicespringsecurity.api.v1.presenter.carro.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarroPresenterModelJson {
    private String nome;
    private String marca;
}
