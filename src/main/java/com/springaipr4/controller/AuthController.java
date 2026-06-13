package com.springaipr4.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.springaipr4.entity.Employee;
import com.springaipr4.repo.EmployeeRepo;

@RestController
@RequestMapping("/api/auth")

public class AuthController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> body) {

        String username = body.get("username");
        String password = body.get("password");

        Map<String, Object> response = new HashMap<>();

        // ADMIN LOGIN
        if ("admin".equals(username) && "admin123".equals(password)) {

            response.put("token", "admin-token");
            response.put("role", "ADMIN");
            response.put("employeeId", 0);
            response.put("name", "Admin");

            return response;
        }

        // EMPLOYEE LOGIN
        Employee emp = employeeRepo.findByEmail(username);

        if (emp != null && emp.getPassword() != null && password != null
                && password.equals(emp.getPassword())) {

            response.put("token", "emp-token");
            response.put("role", "EMPLOYEE");
            response.put("employeeId", emp.getId());
            response.put("name", emp.getFname());
            response.put("email", emp.getEmail());

            return response;
        }

        // INVALID
        response.put("token", "");
        response.put("role", "INVALID");
        response.put("employeeId", -1);
        response.put("name", "");

        return response;
    }
}