package com.springaipr4.controller;

import com.springaipr4.dto.AttendanceSummary;
import com.springaipr4.entity.Attendance;
import com.springaipr4.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")

public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    // ➜ Check-in
    @PostMapping("/checkin/{employeeId}")
    public Attendance checkIn(@PathVariable Long employeeId) {
        return attendanceService.checkIn(employeeId);
    }

    // ➜ Check-out
    @PostMapping("/checkout/{employeeId}")
    public Attendance checkOut(@PathVariable Long employeeId) {
        return attendanceService.checkOut(employeeId);
    }

    // ➜ Monthly summary
    @GetMapping("/summary/{employeeId}/{year}/{month}")
    public AttendanceSummary getSummary(
            @PathVariable Long employeeId,
            @PathVariable int year,
            @PathVariable int month) {

        return attendanceService.getMonthlySummary(employeeId, year, month);
    }

    // ➜ Today attendance
    @GetMapping("/today")
    public List<Attendance> getTodayAttendance() {
        return attendanceService.getTodayAttendance();
    }

    // ➜ All attendance records
    @GetMapping
    public List<Attendance> getAllAttendance() {
        return attendanceService.getAllAttendance();
    }

    // ➜ Employee attendance history
    @GetMapping("/employee/{employeeId}")
    public List<Attendance> getEmployeeAttendance(@PathVariable Long employeeId) {
        return attendanceService.getEmployeeAttendance(employeeId);
    }
}