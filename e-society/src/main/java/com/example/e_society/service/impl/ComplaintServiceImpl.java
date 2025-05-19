package com.example.e_society.service.impl;

import com.example.e_society.model.Complaint;
import com.example.e_society.repository.ComplaintRepository;
import com.example.e_society.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintRepository repo;

    @Override
    public Complaint saveComplaint(Complaint complaint) {
        return repo.save(complaint);
    }

    @Override
    public List<Complaint> getAllComplaints() {
        return repo.findAll();
    }

    @Override
    public Optional<Complaint> getComplaintById(int id) {
        return repo.findById(id);
    }

    @Override
    public void deleteComplaint(int id) {
        repo.deleteById(id);
    }
}
