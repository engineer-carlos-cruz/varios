package com.company.employeescheduling.service;

import com.company.employeescheduling.domain.Shift;
import com.company.employeescheduling.repository.ShiftRepository;
import java.time.LocalTime;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShiftService {
    private final ShiftRepository shiftRepository;

    public ShiftService(ShiftRepository shiftRepository) {
        this.shiftRepository = shiftRepository;
    }

    @Transactional(readOnly = true)
    public List<Shift> list() {
        return shiftRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Shift get(Long id) {
        return shiftRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Shift not found: " + id));
    }

    @Transactional
    public Shift create(LocalTime startTime, LocalTime endTime) {
        validateShiftTimes(startTime, endTime);
        Shift shift = new Shift(startTime, endTime);
        return shiftRepository.save(shift);
    }

    @Transactional
    public Shift update(Long id, LocalTime startTime, LocalTime endTime) {
        validateShiftTimes(startTime, endTime);
        Shift shift = get(id);
        shift.setStartTime(startTime);
        shift.setEndTime(endTime);
        return shift;
    }

    @Transactional
    public void delete(Long id) {
        if (!shiftRepository.existsById(id)) {
            throw new NotFoundException("Shift not found: " + id);
        }
        shiftRepository.deleteById(id);
    }

    private void validateShiftTimes(LocalTime startTime, LocalTime endTime) {
        if (startTime == null || endTime == null || !startTime.isBefore(endTime)) {
            throw new InvalidShiftException("Shift startTime must be before endTime");
        }
    }
}
