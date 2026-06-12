package com.springaipr4.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class LeaveRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;

    private String employeeName;

    private String leaveType;

    private String fromDate;

    private String toDate;

    private String reason;

    private String status;
}