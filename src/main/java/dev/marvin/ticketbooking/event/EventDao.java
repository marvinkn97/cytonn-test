package dev.marvin.ticketbooking.event;

import java.util.List;
import java.util.Optional;

public interface EventDao {
    List<Event> findAllEvents();
    Optional<Event> findEventById(Long id);
    Event save(Event event);
    void deleteEventById(Long id);
}
