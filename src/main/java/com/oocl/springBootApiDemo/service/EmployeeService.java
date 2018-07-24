package com.oocl.springBootApiDemo.service;

import com.oocl.springBootApiDemo.entity.Employee;

import java.util.List;

/**
 * @author Dylan Wei
 * @date 2018-07-24 16:40
 */
public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Integer id);

    Boolean addEmployee(Employee employee);

    Boolean updateEmployee(Employee employee);

    Boolean removeEmployee(Integer id);

}
