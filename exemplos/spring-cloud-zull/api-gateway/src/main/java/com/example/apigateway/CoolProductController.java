package com.example.apigateway;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
class CoolProductController {
    private final ProductClient carClient;
    public CoolProductController(ProductClient carClient) {
        this.carClient = carClient;
    }
    private Collection<Product> fallback() {
        return new ArrayList<>();
    }
    @GetMapping("/cool-products")
    @CrossOrigin
    @HystrixCommand(fallbackMethod = "fallback")
    public Collection<Product> goodCars() {
        return carClient.readProducts()
                .getContent()
                .stream()
                .filter(this::isCool)
                .collect(Collectors.toList());
    }
    private boolean isCool(Product product) {
        return !product.getName().equals("AMC Gremlin") &&
                !product.getName().equals("Triumph Stag") &&
                !product.getName().equals("Ford Pinto") &&
                !product.getName().equals("Yugo GV");
    }
}