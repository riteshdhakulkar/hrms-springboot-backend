package com.springaipr4.service;

import com.springaipr4.entity.LeaveRequest;

import java.util.List;

public interface LeaveService {

    LeaveRequest applyLeave(LeaveRequest leaveRequest);

    List<LeaveRequest> getAllLeaves();

    List<LeaveRequest> getEmployeeLeaves(Long employeeId);

    LeaveRequest approveLeave(Long leaveId);

    LeaveRequest rejectLeave(Long leaveId);
}