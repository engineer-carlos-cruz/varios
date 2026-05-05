package com.company.employeescheduling.api.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class ScheduleRequest {
    @NotNull
    private Long employeeId;

    @NotNull
    private Long shiftId;

    @NotNull
    private LocalDate date;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getShiftId() {
        return shiftId;
    }

    public void setShiftId(Long shiftId) {
        this.shiftId = shiftId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
