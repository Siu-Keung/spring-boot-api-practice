package com.oocl.springBootApiDemo.service.impl;

import com.oocl.springBootApiDemo.entity.Employee;
import com.oocl.springBootApiDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Dylan Wei
 * @date 2018-07-24 16:44
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private List<Employee> allEmployees;

    @Override
    public List<Employee> getAllEmployees() {
        return this.allEmployees;
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        Optional<Employee> optional = this.allEmployees.stream().filter(item -> item.getId().equals(id)).findFirst();
        if(optional.isPresent())
            return optional.get();
        else
            return null;
    }

    @Override
    public Boolean addEmployee(Employee employee) {
        if(this.allEmployees.indexOf(employee) != -1)
            return false;
        this.allEmployees.add(employee);
        return true;
    }

    @Override
    public Boolean updateEmployee(Employee employee) {
        int index = this.allEmployees.indexOf(employee);
        if(-1 == index)
            return false;
        Employee targetEmployee = this.allEmployees.get(index);
        targetEmployee.setName(employee.getName());
        targetEmployee.setAge(employee.getAge());
        targetEmployee.setGender(employee.getGender());
        return true;
    }

    @Override
    public Boolean removeEmployee(Integer id) {
        return this.allEmployees.remove(new Employee(id));
    }
}
