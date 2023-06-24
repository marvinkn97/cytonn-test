package dev.marvin.ticketbooking.event;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class EventService {
    private final EventDao eventDao;

    List<Event> getAllEvents(){
        return eventDao.findAllEvents();
    }

    Event geEventById(UUID eventId){
        return eventDao.findEventById(eventId);
    }

    Event getEventByName(String eventName){
        return eventDao.findEventByName(eventName);
    }

    Event createEvent(EventDto eventDto){
        return null;
    }
}
