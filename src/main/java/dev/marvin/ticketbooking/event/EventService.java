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

    public Event geEventById(Long eventId) {
        return eventDao.findEventById(eventId);
    }

    public Event createEvent(EventDto eventDto) {
        Event newEvent = Event.builder()
                .name(eventDto.name())
                .startDate(eventDto.startDate())
                .endDate(eventDto.endDate())
                .location(eventDto.location())
                .capacity(eventDto.capacity())
                .host(eventDto.host())
                .description(eventDto.description())
                .build();

        return eventDao.save(newEvent);
    }

    public Event updateEvent(Long eventId, EventDto eventUpdateRequest) {
        Event event = eventDao.findEventById(eventId);
        boolean changes = false;

        if (event == null) {
            throw new ResourceNotFoundException("event with id [%s] not found".formatted(eventId));
        }
        if (eventUpdateRequest.name() != null && !eventUpdateRequest.name().equals(event.getName())) {
            event.setName(eventUpdateRequest.name());
            changes = true;
        }
        if (eventUpdateRequest.startDate() != null && !eventUpdateRequest.startDate().equals(event.getStartDate())) {
            event.setStartDate(eventUpdateRequest.startDate());
            changes = true;
        }
        if (eventUpdateRequest.endDate() != null && !eventUpdateRequest.endDate().equals(event.getEndDate())) {
            event.setEndDate(eventUpdateRequest.endDate());
            changes = true;
        }
        if (eventUpdateRequest.location() != null && !eventUpdateRequest.location().equals(event.getLocation())) {
            event.setLocation(eventUpdateRequest.location());
            changes = true;
        }
        if (eventUpdateRequest.capacity() != null && !eventUpdateRequest.capacity().equals(event.getCapacity())) {
            event.setCapacity(eventUpdateRequest.capacity());
            changes = true;
        }
        if (eventUpdateRequest.host() != null && !eventUpdateRequest.host().equals(event.getHost())) {
            event.setHost(eventUpdateRequest.host());
            changes = true;
        }
        if (eventUpdateRequest.description() != null && !eventUpdateRequest.description().equals(event.getDescription())) {
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
