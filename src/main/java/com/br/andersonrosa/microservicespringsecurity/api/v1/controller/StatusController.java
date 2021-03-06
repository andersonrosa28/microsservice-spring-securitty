package com.br.andersonrosa.microservicespringsecurity.api.v1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/status")
public class StatusController {

    @GetMapping
    @ResponseBody
    public String status(){
        return HttpStatus.OK.toString();
    }

}
