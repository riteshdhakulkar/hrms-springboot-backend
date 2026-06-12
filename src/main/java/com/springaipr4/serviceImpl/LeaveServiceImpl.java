package com.springaipr4.serviceImpl;

import com.springaipr4.entity.LeaveRequest;
import com.springaipr4.repo.LeaveRepo;
import com.springaipr4.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveServiceImpl implements LeaveService {

    @Autowired
    private LeaveRepo leaveRepo;

    @Override
    public LeaveRequest applyLeave(LeaveRequest leaveRequest) {

        leaveRequest.setStatus("PENDING");

        return leaveRepo.save(leaveRequest);
    }

    @Override
    public List<LeaveRequest> getAllLeaves() {
        return leaveRepo.findAll();
    }

    @Override
    public List<LeaveRequest> getEmployeeLeaves(Long employeeId) {
        return leaveRepo.findByEmployeeId(employeeId);
    }

    @Override
    public LeaveRequest approveLeave(Long leaveId) {

        LeaveRequest leave =
                leaveRepo.findById(leaveId)
                        .orElseThrow(() -> new RuntimeException("Leave not found"));

        leave.setStatus("APPROVED");

        return leaveRepo.save(leave);
    }

    @Override
    public LeaveRequest rejectLeave(Long leaveId) {

        LeaveRequest leave =
                leaveRepo.findById(leaveId)
                        .orElseThrow(() -> new RuntimeException("Leave not found"));

        leave.setStatus("REJECTED");

        return leaveRepo.save(leave);
    }
}