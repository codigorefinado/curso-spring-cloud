package com.example.configclient.controller;

import com.example.configclient.configuration.StrategyCalcConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
class MessageRestController {

    @Value("${message:Hello default}")
    private String message;

    @Autowired
    private StrategyCalcConfiguration calcConfiguration;

    @RequestMapping("/message")
    String getMessage() {
        return this.message + " " + calcConfiguration.getStrategyCalc();
    }
}