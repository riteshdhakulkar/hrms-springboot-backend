package com.springaipr4.controller;

import com.springaipr4.entity.LeaveRequest;
import com.springaipr4.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leave")

public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @PostMapping("/apply")
    public LeaveRequest applyLeave(
            @RequestBody LeaveRequest leaveRequest) {

        return leaveService.applyLeave(leaveRequest);
    }

    @GetMapping("/all")
    public List<LeaveRequest> getAllLeaves() {
        return leaveService.getAllLeaves();
    }

    @GetMapping("/employee/{employeeId}")
    public List<LeaveRequest> getEmployeeLeaves(
            @PathVariable Long employeeId) {

        return leaveService.getEmployeeLeaves(employeeId);
    }

    @PutMapping("/approve/{leaveId}")
    public LeaveRequest approveLeave(
            @PathVariable Long leaveId) {

        return leaveService.approveLeave(leaveId);
    }

    @PutMapping("/reject/{leaveId}")
    public LeaveRequest rejectLeave(
            @PathVariable Long leaveId) {

        return leaveService.rejectLeave(leaveId);
    }
}