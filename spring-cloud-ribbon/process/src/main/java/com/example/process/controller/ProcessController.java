package com.example.process.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("process")
public class ProcessController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancer;

    @GetMapping("name")
    public String name() {
//        String url = "http://localhost:9090/person/name";
        String url = "http://PERSON-SERVICE/person/name";
        return restTemplate.getForObject(url, String.class);
    }

    @GetMapping("servers")
    public String servers() {
        ServiceInstance instance = loadBalancer.choose("PERSON-SERVICE");
        if (instance == null) {
            return "serviço não encontrado";
        }
        return instance.getHost() + " " + instance.getPort();
    }
}
