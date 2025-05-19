package com.example.e_society.service;

import com.example.e_society.model.Watchman;

import java.util.List;
import java.util.Optional;

public interface WatchmanService {
    Watchman saveWatchman(Watchman watchman);
    List<Watchman> getAllWatchmen();
    Optional<Watchman> getWatchmanById(int id);
    void deleteWatchman(int id);
}
