package dev.marvin.ticketbooking.event;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record EventDto(
        @NotBlank @NotNull(message = "name is required") String name,

        @NotNull(message = "event date is required") LocalDateTime eventDate,

        @NotBlank @NotNull(message = "location is required") String location,

        @NotNull(message = "capacity is required") Integer capacity,

        @NotBlank @NotNull(message = "description is required") String description) {
}