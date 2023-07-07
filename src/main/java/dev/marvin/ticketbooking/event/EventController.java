package dev.marvin.ticketbooking.event;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Event API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/events")
public class EventController {
    private final EventService eventService;

    @Operation(summary = "Get All Events")
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping
    List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @Operation(summary = "Get Event By ID")
    @GetMapping("/{eventId}")
    ResponseEntity<Event> getEventById(@PathVariable("eventId") UUID eventId) {
        Event event = eventService.geEventById(eventId);

        if (event != null) {
            return ResponseEntity.ok(event);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Operation(summary = "Get Event By Name")
    @GetMapping("/{eventName}")
    ResponseEntity<Event> getEventByName(@PathVariable("eventName") String name) {
        Event event = eventService.getEventByName(name);
        if (event != null) {
            return ResponseEntity.ok(event);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Operation(summary = "Create New Event")
    @PostMapping
    ResponseEntity<Event> createEvent(@Validated @RequestBody EventDto newEventRegistrationRequest) {
        Event savedEvent = eventService.createEvent(newEventRegistrationRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEvent);
    }

    @Operation(summary = "Update Event By ID")
    @PutMapping("/{eventId}")
    ResponseEntity<Event> updateEvent(@PathVariable("eventId") UUID eventId, @Validated @RequestBody EventDto eventUpdateRequest) {
        Event updatedEvent = eventService.updateEvent(eventId, eventUpdateRequest);
        return ResponseEntity.ok(updatedEvent);
    }

    @Operation(summary = "Delete Event By ID")
    @DeleteMapping("/{eventId}")
    ResponseEntity<Event> deleteEventById(@PathVariable("eventId") UUID eventId) {
        eventService.deleteEventById(eventId);
        return ResponseEntity.noContent().build();
    }
}