package com.example.employeeManagement.exception;

public class EmployeeNotFoundException extends RuntimeException {

  public EmployeeNotFoundException(long id) {
    super("Employee with id " + id + " not found.");
  }

}
