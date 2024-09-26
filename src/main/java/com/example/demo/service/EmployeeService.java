package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void  delete(Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee get(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }
}
