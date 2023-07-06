package com.example.employeeManagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeeManagement.exception.EmployeeNotFoundException;
import com.example.employeeManagement.model.Employee;
import com.example.employeeManagement.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

     @Autowired 
     EmployeeRepository employeeRepository;

      // Create
      @Override
      public Employee createEmployee(Employee employee) {
        Employee newEmployee = employeeRepository.save(employee);
        return newEmployee;
  }

  // Get One
  @Override
  public Employee getEmployee(int id) {
    Optional<Employee> foundEmployee = employeeRepository.findById(id);

    if (foundEmployee.isPresent()) {
      return foundEmployee.get();
    } else {
      throw new EmployeeNotFoundException(id);
    }
  }

  // Get All
  @Override
  public List<Employee> getAllEmployees() {
    List<Employee> allEmployees = employeeRepository.findAll();
    return allEmployees;
  }

  // Update
  @Override
  public Employee updateEmployee(int id, Employee employee) {
    Optional<Employee> wrappedEmployeeToUpdate = employeeRepository.findById(id);

    // Early return / Guard clause
    if (!wrappedEmployeeToUpdate.isPresent()) {
      throw new EmployeeNotFoundException(id);
    }

    // Unwrap it
    Employee employeeToUpdate = wrappedEmployeeToUpdate.get();

    // Update the employee retrieved from DB
    employeeToUpdate.setFirstName(employee.getFirstName());
    employeeToUpdate.setLastName(employee.getLastName());
    employeeToUpdate.setEmail(employee.getEmail());

    // Save and return the data
    return employeeRepository.save(employeeToUpdate);
  }

  // Delete
  @Override
  public void deleteEmployee(int id) {
    employeeRepository.deleteById(id);
  }

}
