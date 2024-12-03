package com.nara.circuit_breaker_1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Component
public class EmployeeDetails {
    public List<Employee> empList(){
        return Arrays.asList(
                new Employee(1,"narasimha", 34),
                new Employee(2,"narasimha-2", 24),
                new Employee(3,"narasimha-3", 14),
                new Employee(4,"narasimha-4", 44)
        );
    }
}
