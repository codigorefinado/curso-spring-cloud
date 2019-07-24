package com.example.paymentservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payment")
public class PaymentController {

    //    @LocalServerPort
    @Value("${server.port}")
    int port;


    @GetMapping("payNow/{price}")
    public String payNow(@PathVariable int price) {
        return "Payment with " + price + " successfull on port " + port;
    }
}
