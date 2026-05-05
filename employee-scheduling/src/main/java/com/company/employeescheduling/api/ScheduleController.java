package com.company.employeescheduling.api;

import com.company.employeescheduling.api.dto.ScheduleRequest;
import com.company.employeescheduling.api.dto.ScheduleResponse;
import com.company.employeescheduling.domain.Schedule;
import com.company.employeescheduling.service.ScheduleService;
import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/programaciones")
public class ScheduleController {
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping
    public List<ScheduleResponse> list(
            @RequestParam(required = false) Long empleadoId,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha
    ) {
        if (empleadoId != null && fecha != null) {
            return scheduleService.listByEmployeeAndDate(empleadoId, fecha).stream()
                    .map(ScheduleController::toResponse)
                    .toList();
        }

        if (empleadoId != null) {
            return scheduleService.listByEmployee(empleadoId).stream()
                    .map(ScheduleController::toResponse)
                    .toList();
        }

        if (fecha != null) {
            return scheduleService.listByDate(fecha).stream()
                    .map(ScheduleController::toResponse)
                    .toList();
        }

        return scheduleService.listAll().stream()
                .map(ScheduleController::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public ScheduleResponse get(@PathVariable Long id) {
        return toResponse(scheduleService.get(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ScheduleResponse create(@Valid @RequestBody ScheduleRequest request) {
        Schedule schedule = scheduleService.create(
                request.getEmployeeId(),
                request.getShiftId(),
                request.getDate()
        );
        return toResponse(schedule);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        scheduleService.delete(id);
    }

    private static ScheduleResponse toResponse(Schedule schedule) {
        return new ScheduleResponse(
                schedule.getId(),
                schedule.getDate(),
                schedule.getEmployee().getId(),
                schedule.getEmployee().getName(),
                schedule.getShift().getId(),
                schedule.getShift().getStartTime(),
                schedule.getShift().getEndTime()
        );
    }
}
