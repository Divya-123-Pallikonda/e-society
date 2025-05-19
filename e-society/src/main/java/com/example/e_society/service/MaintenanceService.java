package com.example.e_society.service;

import com.example.e_society.model.Maintenance;

import java.util.List;

public interface MaintenanceService {
    Maintenance saveMaintenance(Maintenance maintenance);
    List<Maintenance> getAllMaintenances();
    Maintenance getMaintenanceById(int id);
    void deleteMaintenance(int id);
}
