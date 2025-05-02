package com.buggers.responseentitydemo.employee.service;

import com.buggers.responseentitydemo.employee.dto.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {

    private final List<Employee> employees;

    public EmployeeServiceImp(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public Employee add(Employee employee) {
        employees.add(employee);
        return employee;
    }

    @Override
    public List<Employee> getEmployee() {
        return employees;
    }

    @Override
    public boolean updateEmployee(Integer id, Employee employee) {
        for(var getId: employees){
            if(getId.getId() == id){
                System.err.println("------------>>"+getId);
                employees.remove(getId);
                employee.setId(id);
                employee.setName(employee.getName());
                employee.setPosition(employee.getPosition());
                employees.add(employee);
                return true;
            }
        }
        return false;
    }
}
