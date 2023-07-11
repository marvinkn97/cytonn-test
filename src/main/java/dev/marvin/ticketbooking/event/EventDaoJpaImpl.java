package dev.marvin.ticketbooking.event;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
    public Optional<Event> findEventById(Long eventId) {
        return eventRepository.findEventById(eventId);
    }

    @Override
    public Event save(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public void deleteEventById(Long eventId) {
        eventRepository.deleteById(eventId);
    }

}
