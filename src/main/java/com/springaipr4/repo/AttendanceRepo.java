package com.springaipr4.repo;

import com.springaipr4.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceRepo extends JpaRepository<Attendance, Long> {

    Attendance findByEmployeeIdAndDate(Long employeeId, LocalDate date);

    List<Attendance> findByEmployeeId(Long employeeId);

    List<Attendance> findByEmployeeIdAndDateBetween(
            Long employeeId,
            LocalDate start,
            LocalDate end
    );

   
    List<Attendance> findByDate(LocalDate date);
}