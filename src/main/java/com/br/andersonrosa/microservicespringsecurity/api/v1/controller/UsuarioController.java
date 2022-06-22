package com.br.andersonrosa.microservicespringsecurity.api.v1.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @GetMapping
    @ResponseBody
    public Map<String, String> token(HttpSession httpSession) {
        Map<String, String> map = new HashMap<>();
        map.put("token", httpSession.getId());
        map.put("nome", SecurityContextHolder.getContext().getAuthentication().getName());
        return map;
    }

}
