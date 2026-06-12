package com.springaipr4.service;

import com.springaipr4.dto.AttendanceSummary;
import com.springaipr4.entity.Attendance;

import java.util.List;

public interface AttendanceService {

    Attendance checkIn(Long employeeId);

    Attendance checkOut(Long employeeId);

    AttendanceSummary getMonthlySummary(
            Long employeeId,
            int year,
            int month
    );

    List<Attendance> getTodayAttendance();

    List<Attendance> getAllAttendance();

    List<Attendance> getEmployeeAttendance(Long employeeId);
}