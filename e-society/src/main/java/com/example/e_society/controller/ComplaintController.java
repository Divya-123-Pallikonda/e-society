package com.example.e_society.controller;

import com.example.e_society.model.Complaint;
import com.example.e_society.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/complaints")
@CrossOrigin("*")   // allow any frontend for now
public class ComplaintController {

    @Autowired
    private ComplaintService service;

    /* ---------- CREATE ---------- */
    @PostMapping
    public ResponseEntity<Complaint> create(@RequestBody Complaint body) {
        return ResponseEntity.ok(service.saveComplaint(body));
    }

    /* ---------- READ ALL ---------- */
    @GetMapping
    public ResponseEntity<List<Complaint>> getAll() {
        return ResponseEntity.ok(service.getAllComplaints());
    }

    /* ---------- READ ONE ---------- */
    @GetMapping("/{id}")
    public ResponseEntity<Complaint> getById(@PathVariable int id) {
        return service.getComplaintById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /* ---------- UPDATE ---------- */
    @PutMapping("/{id}")
    public ResponseEntity<Complaint> update(@PathVariable int id,
                                            @RequestBody Complaint body) {
        return service.getComplaintById(id)
                .map(existing -> {
                    existing.setSubject(body.getSubject());
                    existing.setDetails(body.getDetails());
                    existing.setStatus(body.getStatus());
                    return ResponseEntity.ok(service.saveComplaint(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    /* ---------- DELETE ---------- */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.deleteComplaint(id);
        return ResponseEntity.noContent().build();
    }
}
