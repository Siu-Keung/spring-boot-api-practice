package com.oocl.springBootApiDemo.controller;

import com.oocl.springBootApiDemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees(){
        return this.allEmployees;
    }

    @GetMapping("/employeeInfo/{employeeId}")
    public Employee getEmployeeById(@PathVariable Integer employeeId){
        return this.allEmployees.stream().filter(employee -> employee.getId().equals(employeeId)).findFirst().get();
    }

    @PostMapping("/addEmployee")
    public String addEmployee(Employee newEmployee){
        if(this.allEmployees.indexOf(newEmployee) != -1)
            return "failed";
        this.allEmployees.add(newEmployee);
        return "succeeded";
    }

    @PostMapping("/updateEmployee")
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

    @PostMapping("/deleteEmployee/{employeeId}")
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
