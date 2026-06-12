package com.springaipr4.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import com.ems.enitity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

  Employee findByEmail(String email);
}