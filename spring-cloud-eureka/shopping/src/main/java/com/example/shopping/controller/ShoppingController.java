package com.example.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("shopping")
public class ShoppingController {
    @Autowired
    private RestTemplate template;

    @GetMapping("payment/{price}")
    public String invokePaymentService(@PathVariable int price) {
//        String url = "http://localhost:8888/payment/payNow/" + price;

        String url = "http://PAYMENT-SERVICE/payment/payNow/" + price;

        return template.getForObject(url, String.class);
    }

}
