package com.oocl.springBootApiDemo.controller;

import com.oocl.springBootApiDemo.entity.Employee;
import com.oocl.springBootApiDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author Dylan Wei
 * @date 2018-07-24 12:47
 */
@RestController
public class AppController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return this.employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable Integer employeeId){
        return this.employeeService.getEmployeeById(employeeId);
    }

    @PostMapping("/employees")
    public String addEmployee(Employee newEmployee){
        if(this.employeeService.addEmployee(newEmployee))
            return "succeeded";
        else
            return "failed";
    }

    @PutMapping("/employees/{employeeId}")
    public String updateEmployee(Employee newEmployee){
        if(this.employeeService.updateEmployee(newEmployee))
            return "succeeded";
        else
            return "failed";
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable Integer employeeId){
        if(this.employeeService.removeEmployee(employeeId))
            return "succeeded";
        else
            return "failed";
    }


}
