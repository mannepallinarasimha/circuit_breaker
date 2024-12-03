package com.nara.circuit_breaker_2;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class EmployeeController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("empList")
    @CircuitBreaker(name="circuit_breaker", fallbackMethod = "fallBackMethodForEmpList")
    public List<Employee> empDetailsFromAnotherService(){
        return List.of(restTemplate.getForObject("http://localhost:9090/api/v1/employee/all", Employee[].class));
    }

    public List<Employee> fallBackMethodForEmpList(Exception e){
        return Arrays.asList(
                new Employee(1,"Dummy", 34),
                new Employee(2,"Dummy-2", 24),
                new Employee(3,"Dummy-3", 14),
                new Employee(4,"Dummy-4", 44)
        );
    }
}
