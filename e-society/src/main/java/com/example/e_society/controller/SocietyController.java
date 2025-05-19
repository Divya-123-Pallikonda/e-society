package com.example.e_society.controller;

import com.example.e_society.model.Society;
import com.example.e_society.service.SocietyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/societies")
@CrossOrigin(origins = "*")
public class SocietyController {

    @Autowired
    private SocietyService societyService;

    @PostMapping
    public ResponseEntity<Society> createSociety(@RequestBody Society society) {
        Society created = societyService.saveSociety(society);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<Society>> getAllSocieties() {
        List<Society> societies = societyService.getAllSocieties();
        return ResponseEntity.ok(societies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Society> getSocietyById(@PathVariable int id) {
        Optional<Society> society = societyService.getSocietyById(id);
        return society.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSociety(@PathVariable int id) {
        societyService.deleteSociety(id);
        return ResponseEntity.noContent().build();
    }
    
    /* ---------- UPDATE ---------- */
    @PutMapping("/{id}")
    public ResponseEntity<Society> updateSociety(@PathVariable int id,
                                                 @RequestBody Society body) {
        Optional<Society> existingOpt = societyService.getSocietyById(id);
        if (existingOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Society existing = existingOpt.get();
        existing.setName(body.getName());
        existing.setAddress(body.getAddress());
        existing.setCity(body.getCity());

        Society saved = societyService.saveSociety(existing); // reuse save
        return ResponseEntity.ok(saved);
    }

}
