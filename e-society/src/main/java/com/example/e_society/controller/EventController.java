package com.example.e_society.controller;

import com.example.e_society.model.Event;
import com.example.e_society.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    // Create new Event
    @PostMapping
    public Event save(@RequestBody Event event) {
        return eventService.saveEvent(event);
    }

    // Get all Events
    @GetMapping
    public List<Event> getAll() {
        return eventService.getAllEvents();
    }

    // Get Event by ID
    @GetMapping("/{id}")
    public Event getById(@PathVariable int id) {
        return eventService.getEventById(id);
    }

    // Update Event
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Event updatedEvent) {
        Event existingEvent = eventService.getEventById(id);
        if (existingEvent != null) {
            existingEvent.setTitle(updatedEvent.getTitle());
            existingEvent.setDescription(updatedEvent.getDescription());
            existingEvent.setDate(updatedEvent.getDate());
            eventService.saveEvent(existingEvent);
            return ResponseEntity.ok("Updated successfully");
        } else {
            return ResponseEntity.status(404).body("Event not found");
        }
    }

    // Delete Event
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        eventService.deleteEvent(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}
