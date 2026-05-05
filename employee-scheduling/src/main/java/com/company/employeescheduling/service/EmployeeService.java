package com.company.employeescheduling.service;

import com.company.employeescheduling.domain.Employee;
import com.company.employeescheduling.repository.EmployeeRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional(readOnly = true)
    public List<Employee> list() {
        return employeeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Employee get(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Employee not found: " + id));
    }

    @Transactional
    public Employee create(String name, String email) {
        Employee employee = new Employee(name, email);
        return employeeRepository.save(employee);
    }

    @Transactional
    public Employee update(Long id, String name, String email) {
        Employee employee = get(id);
        employee.setName(name);
        employee.setEmail(email);
        return employee;
    }

    @Transactional
    public void delete(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new NotFoundException("Employee not found: " + id);
        }
        employeeRepository.deleteById(id);
    }
}
