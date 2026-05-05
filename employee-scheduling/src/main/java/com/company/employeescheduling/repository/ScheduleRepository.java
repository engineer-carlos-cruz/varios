package com.company.employeescheduling.repository;

import com.company.employeescheduling.domain.Schedule;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByEmployeeId(Long employeeId);

    List<Schedule> findByEmployeeIdAndDate(Long employeeId, LocalDate date);

    List<Schedule> findByDate(LocalDate date);

    @Query("""
            select (count(s) > 0)
            from Schedule s
            join s.shift sh
            where s.employee.id = :employeeId
              and s.date = :date
              and sh.startTime < :endTime
              and sh.endTime > :startTime
            """)
    boolean existsOverlappingSchedule(
            @Param("employeeId") Long employeeId,
            @Param("date") LocalDate date,
            @Param("startTime") LocalTime startTime,
            @Param("endTime") LocalTime endTime
    );
}
