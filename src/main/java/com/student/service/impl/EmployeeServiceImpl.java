package com.student.service.impl;

import com.student.model.Employee;
import com.student.repository.EmployeeRepository;
import com.student.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(long id, Employee employee) {
        return employeeRepository.findById(id)
                .map(employee1 -> {
                    employee1.setFirstName(employee.getFirstName());
                    employee1.setLastName(employee.getLastName());
                    employee1.setEmail(employee.getEmail());
                    employee1.setDepartment(employee.getDepartment());
                    return employeeRepository.save(employee1);
                }).orElse( null);
    }

    @Override
    public String deleteEmployee(long id) {
        employeeRepository.deleteById(id);
        return "Employee Deleted Successfully";
    }
}
