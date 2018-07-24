package com.oocl.springBootApiDemo.service.impl;

import com.oocl.springBootApiDemo.entity.Employee;
import com.oocl.springBootApiDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public Boolean addEmployee(Employee employee) {
        return null;
    }

    @Override
    public Boolean updateEmployee(Employee employee) {
        return null;
    }

    @Override
    public Boolean removeEmployee(Integer id) {
        return null;
    }
}
