package com.springaipr4.service;

import com.ems.enitity.Employee;

public interface EmployeeService {

    Employee AddData(Employee employee);

    Employee getData(String email);

    Employee updateData(Employee employee);

	String deleteData(String email);
}