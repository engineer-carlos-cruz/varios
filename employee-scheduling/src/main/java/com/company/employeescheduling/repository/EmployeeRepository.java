package com.company.employeescheduling.repository;

import com.company.employeescheduling.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
