package com.br.andersonrosa.microservicespringsecurity.api.v1.presenter.carro;

import com.br.andersonrosa.microservicespringsecurity.domain.carro.entry.dto.CarroOutput;

public interface CarroPresenter<T> {
    T criaPresenterCarro(CarroOutput carroOutput) throws Exception;
}
