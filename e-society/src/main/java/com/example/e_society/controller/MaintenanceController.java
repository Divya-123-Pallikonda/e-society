package com.example.e_society.controller;

import com.example.e_society.model.Maintenance;
import com.example.e_society.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maintenances")
public class MaintenanceController {

    @Autowired
    private MaintenanceService maintenanceService;

    // ✅ Create new maintenance record
    @PostMapping
    public ResponseEntity<String> save(@RequestBody Maintenance maintenance) {
        maintenanceService.saveMaintenance(maintenance);
        return ResponseEntity.ok("Maintenance created successfully");
    }

    // ✅ Get all maintenance records
    @GetMapping
    public List<Maintenance> getAll() {
        return maintenanceService.getAllMaintenances();
    }

    // ✅ Get maintenance by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        Maintenance maintenance = maintenanceService.getMaintenanceById(id);
        if (maintenance != null) {
            return ResponseEntity.ok(maintenance);
        } else {
            return ResponseEntity.status(404).body("Maintenance record not found");
        }
    }

    // ✅ Update maintenance by ID
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Maintenance updatedMaintenance) {
        Maintenance existing = maintenanceService.getMaintenanceById(id);
        if (existing != null) {
            existing.setType(updatedMaintenance.getType());
            existing.setAmount(updatedMaintenance.getAmount());
            existing.setDueDate(updatedMaintenance.getDueDate());
            existing.setPaid(updatedMaintenance.isPaid());

            maintenanceService.saveMaintenance(existing);
            return ResponseEntity.ok("Maintenance updated successfully");
        } else {
            return ResponseEntity.status(404).body("Maintenance record not found");
        }
    }

    // ✅ Delete maintenance by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        maintenanceService.deleteMaintenance(id);
        return ResponseEntity.ok("Maintenance deleted successfully");
    }
}
