package com.company.employeescheduling.api.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class ScheduleResponse {
    private Long id;
    private LocalDate date;
    private Long employeeId;
    private String employeeName;
    private Long shiftId;
    private LocalTime shiftStartTime;
    private LocalTime shiftEndTime;

    public ScheduleResponse(
            Long id,
            LocalDate date,
            Long employeeId,
            String employeeName,
            Long shiftId,
            LocalTime shiftStartTime,
            LocalTime shiftEndTime
    ) {
        this.id = id;
        this.date = date;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.shiftId = shiftId;
        this.shiftStartTime = shiftStartTime;
        this.shiftEndTime = shiftEndTime;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public Long getShiftId() {
        return shiftId;
    }

    public LocalTime getShiftStartTime() {
        return shiftStartTime;
    }

    public LocalTime getShiftEndTime() {
        return shiftEndTime;
    }
}
