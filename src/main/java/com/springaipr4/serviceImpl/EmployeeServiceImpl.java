package com.springaipr4.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springaipr4.entity.Employee;
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
	public ResponseEntity<?>  updateData(Employee employee) {
		
	
	Employee emp = 	employeeRepo.findByEmail(employee.getEmail());
	


	if(emp==null) {
		return ResponseEntity.badRequest().body("employee data not found");
	}
		
		
		return ResponseEntity.ok(employeeRepo.save(employee));
	}

	@Override
	public Employee getData(String  email) {
		// TODO Auto-generated method stub
		return employeeRepo.findByEmail(email);
	}

	@Override
	public ResponseEntity<?> delete(String email) {
		
		
		

		Employee emp = 	employeeRepo.findByEmail(email);
		


		if(emp==null) {
			return ResponseEntity.badRequest().body("employee data not found");
		}
		
		
		
	employeeRepo.deleteById(emp.getId());
	
		
		return ResponseEntity.ok("delete successfully");
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepo.findAll();
	}

	@Override
	public Employee findById(Long id) {
	    return employeeRepo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Employee not found"));
	}

}
