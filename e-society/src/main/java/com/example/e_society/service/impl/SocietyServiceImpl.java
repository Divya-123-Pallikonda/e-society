package com.example.e_society.service.impl;

import com.example.e_society.model.Society;
import com.example.e_society.repository.SocietyRepository;
import com.example.e_society.service.SocietyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SocietyServiceImpl implements SocietyService {

    @Autowired
    private SocietyRepository societyRepository;

    @Override
    public Society saveSociety(Society society) {
        return societyRepository.save(society);
    }

    @Override
    public List<Society> getAllSocieties() {
        return societyRepository.findAll();
    }

    @Override
    public Optional<Society> getSocietyById(int id) {
        return societyRepository.findById(id);
    }

    @Override
    public void deleteSociety(int id) {
        societyRepository.deleteById(id);
    }
}
