package com.example.e_society.service.impl;

import com.example.e_society.model.Flat;
import com.example.e_society.model.Society;
import com.example.e_society.repository.FlatRepository;
import com.example.e_society.repository.SocietyRepository;
import com.example.e_society.service.FlatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlatServiceImpl implements FlatService {

    @Autowired
    private FlatRepository flatRepository;

    @Autowired
    private SocietyRepository societyRepository;

    /** saveFlat now verifies the societyId exists */
    @Override
    public Flat saveFlat(Flat flat, int societyId) {
        Society society = societyRepository.findById(societyId)
                .orElseThrow(() ->
                        new RuntimeException("Society not found: id=" + societyId));
        flat.setSociety(society);
        return flatRepository.save(flat);
    }

    @Override
    public List<Flat> getAllFlats() {
        return flatRepository.findAll();
    }

    @Override
    public Optional<Flat> getFlatById(int id) {
        return flatRepository.findById(id);
    }

    @Override
    public void deleteFlat(int id) {
        flatRepository.deleteById(id);
    }
}
