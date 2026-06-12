package com.ems.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.enitity.Employee;
import com.springaipr4.repo.EmployeeRepo;
import com.springaipr4.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public Employee AddData(Employee employee) {

        return employeeRepo.save(employee);
    }

    @Override
    public Employee getData(String email) {

        return employeeRepo.findByEmail(email);
    }

    @Override
    public Employee updateData(Employee employee) {

        Employee emp = employeeRepo.findByEmail(employee.getEmail());

        if (emp == null) {
            return null;
        }

        return employeeRepo.save(employee);
    }

	@Override
	public String deleteData(String email) {
		// TODO Auto-generated method stub
		return null;
		
	}
}