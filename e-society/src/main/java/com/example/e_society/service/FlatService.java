package com.example.e_society.service;

import com.example.e_society.model.Flat;

import java.util.List;
import java.util.Optional;

public interface FlatService {
    /** create / update while guaranteeing a valid society link */
    Flat saveFlat(Flat flat, int societyId);

    List<Flat> getAllFlats();
    Optional<Flat> getFlatById(int id);
    void deleteFlat(int id);
}
