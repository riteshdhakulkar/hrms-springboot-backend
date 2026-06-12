package com.ems.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ems.enitity.Employee;
import com.springaipr4.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

 
    @PostMapping("/add")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {

        Employee obj = employeeService.AddData(employee);

        return ResponseEntity.ok(obj);
    }

  
    @GetMapping("/get")
    public ResponseEntity<?> getEmployee(@RequestParam String email) {

        Employee getobj = employeeService.getData(email);

        return ResponseEntity.ok(getobj);
    }
   
    @PutMapping("/update")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {

        Employee getobj = employeeService.updateData(employee);

        return ResponseEntity.ok(getobj);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteEmployee(@RequestParam String email) {

        String msg = employeeService.deleteData(email);

        return ResponseEntity.ok(msg);
    }
}