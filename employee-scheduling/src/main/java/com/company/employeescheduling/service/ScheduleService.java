package com.company.employeescheduling.service;

import com.company.employeescheduling.domain.Employee;
import com.company.employeescheduling.domain.Schedule;
import com.company.employeescheduling.domain.Shift;
import com.company.employeescheduling.repository.EmployeeRepository;
import com.company.employeescheduling.repository.ScheduleRepository;
import com.company.employeescheduling.repository.ShiftRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final EmployeeRepository employeeRepository;
    private final ShiftRepository shiftRepository;

    public ScheduleService(
            ScheduleRepository scheduleRepository,
            EmployeeRepository employeeRepository,
            ShiftRepository shiftRepository
    ) {
        this.scheduleRepository = scheduleRepository;
        this.employeeRepository = employeeRepository;
        this.shiftRepository = shiftRepository;
    }

    @Transactional(readOnly = true)
    public List<Schedule> listAll() {
        return scheduleRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Schedule get(Long id) {
        return scheduleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Schedule not found: " + id));
    }

    @Transactional(readOnly = true)
    public List<Schedule> listByEmployee(Long employeeId) {
        return scheduleRepository.findByEmployeeId(employeeId);
    }

    @Transactional(readOnly = true)
    public List<Schedule> listByEmployeeAndDate(Long employeeId, LocalDate date) {
        return scheduleRepository.findByEmployeeIdAndDate(employeeId, date);
    }

    @Transactional(readOnly = true)
    public List<Schedule> listByDate(LocalDate date) {
        return scheduleRepository.findByDate(date);
    }

    @Transactional
    public Schedule create(Long employeeId, Long shiftId, LocalDate date) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new NotFoundException("Employee not found: " + employeeId));
        Shift shift = shiftRepository.findById(shiftId)
                .orElseThrow(() -> new NotFoundException("Shift not found: " + shiftId));

        boolean overlap = scheduleRepository.existsOverlappingSchedule(
                employeeId,
                date,
                shift.getStartTime(),
                shift.getEndTime()
        );

        if (overlap) {
            throw new OverlapException("Employee has overlapping shift on " + date);
        }

        Schedule schedule = new Schedule(date, employee, shift);
        return scheduleRepository.save(schedule);
    }

    @Transactional
    public void delete(Long id) {
        if (!scheduleRepository.existsById(id)) {
            throw new NotFoundException("Schedule not found: " + id);
        }
        scheduleRepository.deleteById(id);
    }
}
