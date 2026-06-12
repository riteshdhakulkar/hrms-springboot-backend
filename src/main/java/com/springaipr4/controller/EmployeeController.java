package com.springaipr4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springaipr4.entity.Employee;
import com.springaipr4.service.EmployeeService;

@RestController
@CrossOrigin("*")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	
	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee employee ){
		
				
		
		
		return employeeService.AddData(employee);

	}
	
	
	@PutMapping("/update")
	public ResponseEntity<?>updateEmployee(@RequestBody Employee employee ){
		
		
		
		
	ResponseEntity<?> updateobj=	employeeService.updateData(employee);
			
	
		
		return ResponseEntity.ok("user updated successfully");
	}
	
	
	
	@GetMapping("/getdatabyemail")
	public ResponseEntity<?>getEmployee(@RequestParam String email ){
		
	Employee getobj=	employeeService.getData(email);
			
		
		
		return ResponseEntity.ok(getobj);
	}
	
	
	@DeleteMapping("/delete")
	ResponseEntity<?> deleteRecord(@RequestParam String email){
		return employeeService.delete(email);
		
	}
	
	@GetMapping("/allemp")
	public List<Employee>getalldata(){
		return employeeService.findAll();
	}

	
	@GetMapping("/employee/{id}")
	public ResponseEntity<?> getEmployeeById(
	        @org.springframework.web.bind.annotation.PathVariable Long id) {

	    return ResponseEntity.ok(
	            employeeService.findById(id)
	    );
	}
}
