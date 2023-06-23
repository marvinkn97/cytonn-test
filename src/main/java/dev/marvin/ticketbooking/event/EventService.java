package dev.marvin.ticketbooking.event;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EventService {
    private final EventDao eventDao;

    List<Event> getAllEvents(){
        return eventDao.findAllEvents();
    }
}
