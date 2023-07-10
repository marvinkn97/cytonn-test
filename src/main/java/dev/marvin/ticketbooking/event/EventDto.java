package dev.marvin.ticketbooking.event;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record EventDto(
        @NotNull(message = "name is required")
        String name,

        @NotNull(message = "start date is required")
        LocalDateTime startDate,

        @NotNull(message = "end date is required")
        LocalDateTime endDate,

        @NotNull(message = "location is required")
        String location,

        @NotNull(message = "capacity is required")
        Integer capacity,

        @NotNull(message = "host is required")
        String host,

        @NotNull(message = "description is required")
        String description) {
}