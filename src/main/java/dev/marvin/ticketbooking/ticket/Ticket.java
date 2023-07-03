package dev.marvin.ticketbooking.ticket;

import dev.marvin.ticketbooking.customer.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Enumerated(EnumType.STRING)
    private TicketType ticketType;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;

    @ManyToOne
    private Event event;

    @ManyToOne
    private Customer customer;
}
