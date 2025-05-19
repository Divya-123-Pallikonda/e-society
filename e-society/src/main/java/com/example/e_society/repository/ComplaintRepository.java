package com.example.e_society.repository;

import com.example.e_society.model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint, Integer> { 

}
