package com.buggers.responseentitydemo.employee.controller;

import com.buggers.responseentitydemo.employee.dto.Employee;
import com.buggers.responseentitydemo.employee.service.EmployeeService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee>addEmployee(@RequestBody Employee employee) {
        var responseBody=employeeService.add(employee);

        var customResponseHeaders = new HttpHeaders();
        customResponseHeaders.add("custom-header", "custom-header-value");

        return ResponseEntity.status(HttpStatus.CREATED)
                .headers(customResponseHeaders)
                .body(responseBody);
    }
    @GetMapping
    public ResponseEntity<List<Employee>>getEmployee() {
        var response=employeeService.getEmployee();
        return ResponseEntity.ok(response);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEmployee(@PathVariable("id") Integer id,@RequestBody Employee employee) {
        var responseBody=employeeService.updateEmployee(id,employee);
        return ResponseEntity.status(responseBody ? HttpStatus.OK : HttpStatus.NOT_FOUND)
                .build();
    }
}
