package com.example.apigateway.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EmployeeController {
    @Autowired
    RestTemplate restTemplate;

    //  Start the application reachable at http://localhost:8010/employeeDetails/111
    @GetMapping(value = "/employeeDetails/{employeeid}")
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String getStudents(@PathVariable int employeeid) {
        System.out.println("Getting Employee details for " + employeeid);

        String response = restTemplate.exchange("http://employee-service/findEmployeeDetails/{employeeid}",
                org.springframework.http.HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
                }, employeeid).getBody();

        System.out.println("Response Body " + response);

        return "Employee Id -  " + employeeid + " [ Employee Details " + response + " ]";
    }

    public String fallbackMethod(int employeeid) {

        return "Fallback response:: No employee details available temporarily";
    }

}
