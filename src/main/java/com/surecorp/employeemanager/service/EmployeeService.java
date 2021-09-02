package com.surecorp.employeemanager.service;

import com.surecorp.employeemanager.exception.UserNotFoundException;
import com.surecorp.employeemanager.model.Employee;
import com.surecorp.employeemanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        this.employeeRepository = repository;
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public Employee findEmployeeById (Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Employee by "+id+" was not found"));
    }

    public Employee findEmployeeByCode (String code) {
        return employeeRepository.findEmployeeByEmployeeCode(code);
    }
}
