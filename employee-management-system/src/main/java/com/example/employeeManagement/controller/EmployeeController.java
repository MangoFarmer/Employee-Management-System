package com.example.employeeManagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeManagement.model.Employee;
import com.example.employeeManagement.services.EmployeeService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  // CRUD
  // 1. CREATE
  @PostMapping("/employees")
  public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
    Employee newEmployee = employeeService.createEmployee(employee);
    return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
  }

  // 2. READ (Get and Get All)
  // Get All Employees
  @GetMapping("/employees")
  public ResponseEntity<List<Employee>> getAllEmployees() {
    List<Employee> allEmployees = employeeService.getAllEmployees();
    return new ResponseEntity<>(allEmployees, HttpStatus.OK);
  }

  // Get Employee
  @GetMapping("/employees/{id}")
  public ResponseEntity<Employee> getEmployee(@PathVariable int id) {
    Employee foundEmployee = employeeService.getEmployee(id);
    return new ResponseEntity<>(foundEmployee, HttpStatus.OK);
  }

  // 3. UPDATE
  @PutMapping("/employees/{id}")
  public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
    Employee updatedEmployee = employeeService.updateEmployee(id, employee);
    return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
  }

  // 4. DELETE
  @DeleteMapping("/employees/{id}")
  public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable int id) {
    employeeService.deleteEmployee(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}

