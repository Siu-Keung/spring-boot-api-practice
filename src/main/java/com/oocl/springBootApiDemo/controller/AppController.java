package com.oocl.springBootApiDemo.controller;

import com.oocl.springBootApiDemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Dylan Wei
 * @date 2018-07-24 12:47
 */
@RestController
public class AppController {
    @Autowired
    private List<Employee> allEmployees;


    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees(){
        return this.allEmployees;
    }

    @GetMapping("/employeeInfo/{employeeId}")
    public Employee getEmployeeById(@PathVariable Integer employeeId){
        return this.allEmployees.stream().filter(employee -> employee.getId().equals(employeeId)).findFirst().get();
    }

}
