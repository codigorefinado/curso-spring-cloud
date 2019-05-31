package com.example.person.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person")
public class PersonController {

    @Value("${server.port}")
    private String port;

    @GetMapping("name")
    public String name() {
        return "Clayton Passos " + port;
    }

}
