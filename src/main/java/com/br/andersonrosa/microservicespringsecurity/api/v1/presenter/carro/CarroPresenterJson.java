package com.br.andersonrosa.microservicespringsecurity.api.v1.presenter.carro;

import com.br.andersonrosa.microservicespringsecurity.api.v1.presenter.carro.model.CarroPresenterModelJson;
import com.br.andersonrosa.microservicespringsecurity.domain.carro.entry.dto.CarroOutput;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class CarroPresenterJson implements CarroPresenter<CarroPresenterModelJson> {

    @Override
    public CarroPresenterModelJson criaPresenterCarro(CarroOutput carroOutput) throws Exception {
        if(validaEntrarNoPresenter(carroOutput)){
            throw new Exception("Entrada invalida");
        }
        return CarroPresenterModelJson
                .builder()
                .nome(carroOutput.getNome())
                .marca(carroOutput.getMarca())
                .build();
    }


    public boolean validaEntrarNoPresenter(CarroOutput carroOutput){
        return carroOutput == null || ObjectUtils.isEmpty(carroOutput.getNome());
    }
}
