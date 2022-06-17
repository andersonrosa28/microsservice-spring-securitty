package com.br.andersonrosa.microservicespringsecurity.domain.carro.entry;

import com.br.andersonrosa.microservicespringsecurity.domain.carro.entry.dto.CarroInput;
import com.br.andersonrosa.microservicespringsecurity.domain.carro.entry.dto.CarroOutput;

public interface CarroEntryGet {
    CarroOutput carro(CarroInput carroInput) throws Exception;
}
