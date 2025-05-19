package com.example.e_society.service;

import com.example.e_society.model.Event;

import java.util.List;

public interface EventService {
    Event saveEvent(Event event);
    List<Event> getAllEvents();
    Event getEventById(int id);
    void deleteEvent(int id);
}
