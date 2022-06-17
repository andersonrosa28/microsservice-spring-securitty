package com.br.andersonrosa.microservicespringsecurity.domain.carro.usecase;

import com.br.andersonrosa.microservicespringsecurity.domain.carro.entry.CarroEntryGet;
import com.br.andersonrosa.microservicespringsecurity.domain.carro.entry.dto.CarroInput;
import com.br.andersonrosa.microservicespringsecurity.domain.carro.entry.dto.CarroOutput;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class CarroUseCaseGet implements CarroEntryGet {

    @Override
    public CarroOutput carro(CarroInput carroInput) throws Exception {
        if(validaEntrada(carroInput)){
            throw new Exception("Entrada está invalida");
        }

        //Aqui é onde será tratada a regra de negocio do caso de uso.

        return CarroOutput
                .builder()
                .nome(carroInput.getNome())
                .marca(carroInput.getMarca())
                .build();
    }

    private boolean validaEntrada(CarroInput carroInput) {
        return carroInput == null || ObjectUtils.isEmpty(carroInput.getNome());
    }

}
