package com.nara.circuit_breaker_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeDetails employeeDetails;

    @GetMapping("all")
    public List<Employee> allEmployeeDetails(){
        return employeeDetails.empList();
    }
}
