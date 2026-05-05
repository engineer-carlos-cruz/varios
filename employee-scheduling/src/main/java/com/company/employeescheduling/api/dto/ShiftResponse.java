package com.company.employeescheduling.api.dto;

import java.time.LocalTime;

public class ShiftResponse {
    private Long id;
    private LocalTime startTime;
    private LocalTime endTime;

    public ShiftResponse(Long id, LocalTime startTime, LocalTime endTime) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
}
