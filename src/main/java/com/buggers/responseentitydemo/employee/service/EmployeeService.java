package com.buggers.responseentitydemo.employee.service;

import com.buggers.responseentitydemo.employee.dto.Employee;

import java.util.List;

public interface EmployeeService {
    Employee add(Employee employee);

    List<Employee> getEmployee();

    boolean updateEmployee(Integer id, Employee employee);
}
