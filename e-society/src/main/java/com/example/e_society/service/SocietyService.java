package com.example.e_society.service;

import com.example.e_society.model.Society;
import java.util.List;
import java.util.Optional;

public interface SocietyService {
    Society saveSociety(Society society);
    List<Society> getAllSocieties();
    Optional<Society> getSocietyById(int id);
    void deleteSociety(int id);
}
