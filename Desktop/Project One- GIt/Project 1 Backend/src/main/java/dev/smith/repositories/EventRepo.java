package dev.smith.repositories;

import dev.smith.models.Event;

import java.util.List;

public interface EventRepo {

    public List<Event> getAllEvents();
    public Event getEvents(int id);
}
