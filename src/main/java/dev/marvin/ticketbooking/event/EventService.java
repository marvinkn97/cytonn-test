package dev.marvin.ticketbooking.event;

import dev.marvin.ticketbooking.exception.RequestValidationException;
import dev.marvin.ticketbooking.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EventService {
    private final EventDao eventDao;

    public List<Event> getAllEvents() {
        return eventDao.findAllEvents();
    }

    public Event getEventById(Long eventId) {
        return eventDao.findEventById(eventId).orElseThrow(() -> new ResourceNotFoundException("event with id [%s] not found".formatted(eventId)));
    }

    public Event createEvent(EventDto eventDto) {
        Event newEvent = Event.builder()
                .name(eventDto.name())
                .eventDate(eventDto.eventDate())
                .location(eventDto.location())
                .capacity(eventDto.capacity())
                .description(eventDto.description())
                .build();

        return eventDao.save(newEvent);
    }

    public Event updateEvent(Long eventId, EventDto eventUpdateRequest) {
        Event event = eventDao.findEventById(eventId).orElseThrow(() -> new ResourceNotFoundException("event with id [%s] not found".formatted(eventId)));
        boolean changes = false;

        if (!eventUpdateRequest.name().equals(event.getName())) {
            event.setName(eventUpdateRequest.name());
            changes = true;
        }

        if (!eventUpdateRequest.eventDate().equals(event.getEventDate())) {
            event.setEventDate(eventUpdateRequest.eventDate());
            changes = true;
        }
        if (!eventUpdateRequest.location().equals(event.getLocation())) {
            event.setLocation(eventUpdateRequest.location());
            changes = true;
        }
        if (!eventUpdateRequest.capacity().equals(event.getCapacity())) {
            event.setCapacity(eventUpdateRequest.capacity());
            changes = true;
        }

        if (!eventUpdateRequest.description().equals(event.getDescription())) {
            event.setDescription(eventUpdateRequest.description());
            changes = true;
        }
        if (!changes) {
            throw new RequestValidationException("no data changes found");
        }
        return eventDao.save(event);
    }

    public void deleteEventById(Long eventId) {
        eventDao.deleteEventById(eventId);
    }

}
