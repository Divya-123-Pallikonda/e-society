package com.example.e_society.controller;

import com.example.e_society.model.Flat;
import com.example.e_society.service.FlatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/flats")
@CrossOrigin(origins = "*")
public class FlatController {

    @Autowired
    private FlatService flatService;

    /* ---------- CREATE ---------- */
    @PostMapping("/society/{societyId}")
    public ResponseEntity<Flat> createFlat(@PathVariable int societyId,
                                           @RequestBody Flat flat) {
        Flat created = flatService.saveFlat(flat, societyId);
        return ResponseEntity.ok(created);
    }

    /* ---------- READ ALL ---------- */
    @GetMapping
    public ResponseEntity<List<Flat>> getAllFlats() {
        return ResponseEntity.ok(flatService.getAllFlats());
    }

    /* ---------- READ ONE ---------- */
    @GetMapping("/{id}")
    public ResponseEntity<Flat> getFlatById(@PathVariable int id) {
        Optional<Flat> flat = flatService.getFlatById(id);
        return flat.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /* ---------- UPDATE ---------- */
    @PutMapping("/{id}/society/{societyId}")
    public ResponseEntity<Flat> updateFlat(@PathVariable int id,
                                           @PathVariable int societyId,
                                           @RequestBody Flat body) {
        Optional<Flat> existingOpt = flatService.getFlatById(id);
        if (existingOpt.isEmpty())
            return ResponseEntity.notFound().build();
        Flat existing = existingOpt.get();
        existing.setNumber(body.getNumber());
        existing.setFloor(body.getFloor());
        existing.setSize(body.getSize());
        Flat saved = flatService.saveFlat(existing, societyId);
        return ResponseEntity.ok(saved);
    }

    /* ---------- DELETE ---------- */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlat(@PathVariable int id) {
        flatService.deleteFlat(id);
        return ResponseEntity.noContent().build();
    }
}
