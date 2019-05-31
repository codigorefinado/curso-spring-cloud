package com.example.process.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

    /**
     * A anotação @LoadBalanced no bean restTemplate indicando que o mesmo utilizará o Ribbon Load Balancer
     */
    @Bean
    @LoadBalanced
    public RestTemplate template() {
        return new RestTemplate();
    }

}
