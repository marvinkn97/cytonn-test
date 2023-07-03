package dev.marvin.ticketbooking.event;

import dev.marvin.ticketbooking.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Primary
@Repository
@RequiredArgsConstructor
public class EventDaoJpaImpl implements EventDao {
    private final EventRepository eventRepository;
    @Override
    public List<Event> findAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event findEventById(UUID eventId) {
        return eventRepository.findEventById(eventId).orElseThrow(() -> new ResourceNotFoundException("event with id " + eventId + " not found"));
    }

    @Override
    public Event save(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public void deleteEventById(UUID eventId) {
        eventRepository.deleteById(eventId);
    }

    @Override
    public Event findEventByName(String eventName) {
        return eventRepository.findEventByName(eventName).orElseThrow(() -> new ResourceNotFoundException(eventName  + " event not found"));
    }
}
