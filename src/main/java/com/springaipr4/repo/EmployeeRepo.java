package com.springaipr4.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springaipr4.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    Employee findByEmail(String email);

}