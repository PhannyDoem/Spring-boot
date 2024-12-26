package com.student.service;

import com.student.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    Optional<Employee> getEmployeeById(Long id);

    List<Employee> getAllEmployees();

    Employee updateEmployee(long id, Employee employee);

    String deleteEmployee(long id);
}
