package com.springaipr4.controller;

import com.springaipr4.dto.AttendanceSummary;
import com.springaipr4.entity.Attendance;
import com.springaipr4.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
@CrossOrigin(origins = "*")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/checkin/{employeeId}")
    public Attendance checkIn(@PathVariable Long employeeId) {
        return attendanceService.checkIn(employeeId);
    }

    @PostMapping("/checkout/{employeeId}")
    public Attendance checkOut(@PathVariable Long employeeId) {
        return attendanceService.checkOut(employeeId);
    }

    @GetMapping("/summary/{employeeId}/{year}/{month}")
    public AttendanceSummary getSummary(
            @PathVariable Long employeeId,
            @PathVariable int year,
            @PathVariable int month) {

        return attendanceService.getMonthlySummary(employeeId, year, month);
    }

    // TODAY ATTENDANCE
    @GetMapping("/today")
    public List<Attendance> getTodayAttendance() {
        return attendanceService.getTodayAttendance();
    }

    // ALL ATTENDANCE REPORTS
    @GetMapping("/all")
    public List<Attendance> getAllAttendance() {
        return attendanceService.getAllAttendance();
    }
    @GetMapping("/employee/{employeeId}")
    public List<Attendance> getEmployeeAttendance(
            @PathVariable Long employeeId) {

        return attendanceService.getEmployeeAttendance(employeeId);
    }
}