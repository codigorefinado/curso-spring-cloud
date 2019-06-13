package com.example.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EmployeeserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeserviceApplication.class, args);
    }

}
