package com.springaipr4.serviceImpl;

import com.springaipr4.dto.AttendanceSummary;
import com.springaipr4.entity.Attendance;
import com.springaipr4.repo.AttendanceRepo;
import com.springaipr4.repo.EmployeeRepo;
import com.springaipr4.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepo attendanceRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public Attendance checkIn(Long employeeId) {

        if (!employeeRepo.findById(employeeId).isPresent()) {
            throw new RuntimeException("Employee not found");
        }

        LocalDate today = LocalDate.now();

        Attendance attendance =
                attendanceRepo.findByEmployeeIdAndDate(employeeId, today);

        if (attendance == null) {
            attendance = new Attendance();
            attendance.setEmployeeId(employeeId);
            attendance.setDate(today);
        }

        attendance.setCheckIn(LocalTime.now());

        if (attendance.getCheckIn().isAfter(LocalTime.of(9, 15))) {
            attendance.setStatus("LATE");
        } else {
            attendance.setStatus("PRESENT");
        }

        return attendanceRepo.save(attendance);
    }

    @Override
    public Attendance checkOut(Long employeeId) {

        LocalDate today = LocalDate.now();

        Attendance attendance =
                attendanceRepo.findByEmployeeIdAndDate(employeeId, today);

        if (attendance == null) {
            throw new RuntimeException("Check-in first required");
        }

        attendance.setCheckOut(LocalTime.now());

        if (attendance.getCheckIn() != null &&
                attendance.getCheckOut() != null) {

            double hours = Duration.between(
                    attendance.getCheckIn(),
                    attendance.getCheckOut()
            ).toMinutes() / 60.0;

            attendance.setWorkingHours(hours);
        }

        return attendanceRepo.save(attendance);
    }

    @Override
    public AttendanceSummary getMonthlySummary(
            Long employeeId,
            int year,
            int month) {

        LocalDate start = LocalDate.of(year, month, 1);
        LocalDate end = start.withDayOfMonth(start.lengthOfMonth());

        List<Attendance> list =
                attendanceRepo.findByEmployeeIdAndDateBetween(
                        employeeId,
                        start,
                        end
                );

        int present = 0;
        int late = 0;
        double totalHours = 0;

        for (Attendance a : list) {

            if ("LATE".equals(a.getStatus())) {
                late++;
            } else {
                present++;
            }

            if (a.getWorkingHours() != null) {
                totalHours += a.getWorkingHours();
            }
        }

        AttendanceSummary dto = new AttendanceSummary();
        dto.setEmployeeId(employeeId);
        dto.setPresentDays(present);
        dto.setLateDays(late);
        dto.setTotalWorkingHours(totalHours);

        return dto;
    }

    @Override
    public List<Attendance> getTodayAttendance() {

        LocalDate today = LocalDate.now();

        return attendanceRepo.findByDate(today);
    }

    @Override
    public List<Attendance> getAllAttendance() {
        return attendanceRepo.findAll();
    }
    @Override
    public List<Attendance> getEmployeeAttendance(Long employeeId) {
        return attendanceRepo.findByEmployeeId(employeeId);
    }
}