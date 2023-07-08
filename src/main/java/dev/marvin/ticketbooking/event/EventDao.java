package dev.marvin.ticketbooking.event;

import java.util.List;

public interface EventDao {
    List<Event> findAllEvents();
    Event findEventById(Long id);
    Event save(Event event);
    void deleteEventById(Long id);
    Event findEventByName(String name);
}
