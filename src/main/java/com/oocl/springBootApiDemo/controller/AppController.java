package com.oocl.springBootApiDemo.controller;

import com.oocl.springBootApiDemo.entity.Employee;
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
    private List<Employee> allEmployees;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return this.allEmployees;
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable Integer employeeId){
        return this.allEmployees.stream().filter(employee -> employee.getId().equals(employeeId)).findFirst().get();
    }

    @PutMapping("/employees")
    public String addEmployee(Employee newEmployee){
        if(this.allEmployees.indexOf(newEmployee) != -1)
            return "failed";
        this.allEmployees.add(newEmployee);
        return "succeeded";
    }

    @PostMapping("/employees/{employeeId}")
    public String updateEmployee(Employee newEmployee){
        int index = this.allEmployees.indexOf(newEmployee);
        if(index == -1)
            return "failed";
        Employee targetEmployee = this.allEmployees.get(index);
        targetEmployee.setName(newEmployee.getName());
        targetEmployee.setAge(newEmployee.getAge());
        targetEmployee.setGender(newEmployee.getGender());
        return "succeeded";
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable Integer employeeId){
        Employee employee = new Employee();
        employee.setId(employeeId);
        boolean succeeded = this.allEmployees.remove(employee);
        if(succeeded)
            return "succeeded";
        else
            return "failed";
    }


}
