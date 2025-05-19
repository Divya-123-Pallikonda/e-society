package com.example.e_society.service.impl;

import com.example.e_society.model.Watchman;
import com.example.e_society.repository.WatchmanRepository;
import com.example.e_society.service.WatchmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WatchmanServiceImpl implements WatchmanService {

    @Autowired
    private WatchmanRepository repo;

    public Watchman saveWatchman(Watchman w) {
        return repo.save(w);
    }

    public List<Watchman> getAllWatchmen() {
        return repo.findAll();
    }

    public Optional<Watchman> getWatchmanById(int id) {
        return repo.findById(id);
    }

    public void deleteWatchman(int id) {
        repo.deleteById(id);
    }
    
}
