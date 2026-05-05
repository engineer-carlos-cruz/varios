package com.company.employeescheduling.api;

import com.company.employeescheduling.api.dto.ShiftRequest;
import com.company.employeescheduling.api.dto.ShiftResponse;
import com.company.employeescheduling.domain.Shift;
import com.company.employeescheduling.service.ShiftService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/turnos")
public class ShiftController {
    private final ShiftService shiftService;

    public ShiftController(ShiftService shiftService) {
        this.shiftService = shiftService;
    }

    @GetMapping
    public List<ShiftResponse> list() {
        return shiftService.list().stream()
                .map(ShiftController::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public ShiftResponse get(@PathVariable Long id) {
        return toResponse(shiftService.get(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShiftResponse create(@Valid @RequestBody ShiftRequest request) {
        Shift shift = shiftService.create(request.getStartTime(), request.getEndTime());
        return toResponse(shift);
    }

    @PutMapping("/{id}")
    public ShiftResponse update(@PathVariable Long id, @Valid @RequestBody ShiftRequest request) {
        Shift shift = shiftService.update(id, request.getStartTime(), request.getEndTime());
        return toResponse(shift);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        shiftService.delete(id);
    }

    private static ShiftResponse toResponse(Shift shift) {
        return new ShiftResponse(shift.getId(), shift.getStartTime(), shift.getEndTime());
    }
}
