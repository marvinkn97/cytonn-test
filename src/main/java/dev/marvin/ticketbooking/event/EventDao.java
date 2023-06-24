package dev.marvin.ticketbooking.event;

import java.util.List;
import java.util.UUID;

public interface EventDao {
    List<Event> findAllEvents();
    Event findEventById(UUID id);
    Event save(Event event);
    void deleteEventById(UUID id);

    Event findEventByName(String name);
}
