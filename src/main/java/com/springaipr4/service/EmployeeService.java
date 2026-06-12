package com.springaipr4.service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.springaipr4.entity.Employee;

public interface EmployeeService {

    Employee AddData(Employee employee);

    ResponseEntity<?> updateData(Employee employee);

    Employee getData(String email);

    ResponseEntity<?> delete(String email);

    List<Employee> findAll();

    Employee findById(Long id);
}