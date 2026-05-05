package com.company.employeescheduling.repository;

import com.company.employeescheduling.domain.Shift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShiftRepository extends JpaRepository<Shift, Long> {
}
