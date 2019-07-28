package com.example.apigateway;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("product-service")
interface ProductClient {
    @GetMapping("/products")
    @CrossOrigin
    Resources<Product> readProducts();
}
