package com.springaipr4.dto;

import lombok.Data;

@Data
public class AttendanceSummary {

    private Long employeeId;
    private int presentDays;
    private int lateDays;
    private double totalWorkingHours;
}