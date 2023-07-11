package dev.marvin.ticketbooking.ticket;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record TicketDto(
        @NotNull(message = "ticket type is required") String ticketType,
        @NotNull(message = "price is required") BigDecimal price,
        @NotNull(message = "quantity is required") Integer quantity) {
}
