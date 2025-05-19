package com.example.e_society.controller;

import com.example.e_society.model.Watchman;
import com.example.e_society.service.WatchmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/watchmen")
@CrossOrigin(origins = "*")
public class WatchmanController {

    @Autowired
    private WatchmanService watchmanService;

    @PostMapping
    public ResponseEntity<Watchman> create(@RequestBody Watchman watchman) {
        return ResponseEntity.ok(watchmanService.saveWatchman(watchman));
    }

    @GetMapping
    public ResponseEntity<List<Watchman>> getAll() {
        return ResponseEntity.ok(watchmanService.getAllWatchmen());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Watchman> getById(@PathVariable int id) {
        Optional<Watchman> found = watchmanService.getWatchmanById(id);
        return found.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Watchman> update(@PathVariable int id,
                                           @RequestBody Watchman body) {
        Optional<Watchman> found = watchmanService.getWatchmanById(id);
        if (found.isEmpty()) return ResponseEntity.notFound().build();

        Watchman existing = found.get();
        existing.setName(body.getName());
        existing.setPhone(body.getPhone());
        existing.setShift(body.getShift());

        return ResponseEntity.ok(watchmanService.saveWatchman(existing));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        watchmanService.deleteWatchman(id);
        return ResponseEntity.noContent().build();
    }
}
