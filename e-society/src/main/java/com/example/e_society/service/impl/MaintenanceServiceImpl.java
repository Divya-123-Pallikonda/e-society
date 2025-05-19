package com.example.e_society.service.impl;

import com.example.e_society.model.Maintenance;
import com.example.e_society.repository.MaintenanceRepository;
import com.example.e_society.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    @Autowired
    private MaintenanceRepository maintenanceRepository;

    @Override
    public Maintenance saveMaintenance(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public List<Maintenance> getAllMaintenances() {
        return maintenanceRepository.findAll();
    }

    @Override
    public Maintenance getMaintenanceById(int id) {
        return maintenanceRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteMaintenance(int id) {
        maintenanceRepository.deleteById(id);
    }
}
