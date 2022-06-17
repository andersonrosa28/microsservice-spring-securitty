package com.br.andersonrosa.microservicespringsecurity.api.v1.controller;

import com.br.andersonrosa.microservicespringsecurity.api.v1.presenter.carro.CarroPresenter;
import com.br.andersonrosa.microservicespringsecurity.api.v1.presenter.carro.model.CarroPresenterModelJson;
import com.br.andersonrosa.microservicespringsecurity.domain.carro.entry.CarroEntryGet;
import com.br.andersonrosa.microservicespringsecurity.domain.carro.entry.dto.CarroInput;
import com.br.andersonrosa.microservicespringsecurity.domain.carro.entry.dto.CarroOutput;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/api")
public class CarroController {

    private CarroPresenter<CarroPresenterModelJson> carroPresenter;
    private CarroEntryGet carroEntryGet;

    @GetMapping("/carro")
    @ResponseBody
    public CarroPresenterModelJson getCarro() throws Exception {
        CarroInput carroInput = new CarroInput("Civic", "Honda");

        CarroOutput carroOutput = carroEntryGet.carro(carroInput);

        return carroPresenter.criaPresenterCarro(carroOutput);
    }
}
