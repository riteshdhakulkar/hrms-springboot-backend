package com.springaipr4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springaipr4.entity.Employee;
import com.springaipr4.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")

public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // ➜ Add Employee
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.AddData(employee);
    }

    // ➜ Update Employee
    @PutMapping
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
        employeeService.updateData(employee);
        return ResponseEntity.ok("User updated successfully");
    }

    // ➜ Get Employee by Email
    @GetMapping("/email")
    public ResponseEntity<?> getEmployeeByEmail(@RequestParam String email) {
        return ResponseEntity.ok(employeeService.getData(email));
    }

    // ➜ Delete Employee by Email
    @DeleteMapping
    public ResponseEntity<?> deleteEmployee(@RequestParam String email) {
        return employeeService.delete(email);
    }

    // ➜ Get All Employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    // ➜ Get Employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.findById(id));
    }
}