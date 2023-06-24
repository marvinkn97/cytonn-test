package dev.marvin.ticketbooking.event;

import java.time.LocalDateTime;

public record EventDto(
        String name, String location, Integer capacity, LocalDateTime eventDate) {
}
