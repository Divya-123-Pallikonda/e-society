package com.example.e_society.service;

import com.example.e_society.model.Complaint;
import java.util.List;
import java.util.Optional;

public interface ComplaintService {
    Complaint saveComplaint(Complaint complaint);
    List<Complaint> getAllComplaints();
    Optional<Complaint> getComplaintById(int id);
    void deleteComplaint(int id);
}
