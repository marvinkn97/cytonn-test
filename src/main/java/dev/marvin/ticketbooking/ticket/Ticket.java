package dev.marvin.ticketbooking.ticket;

import dev.marvin.ticketbooking.event.Event;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ticket {
    @Id
    @SequenceGenerator(name = "ticket_id_sequence", sequenceName = "ticket_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_id_sequence")
    private Long id;

    @Enumerated(EnumType.STRING)
    private TicketType ticketType;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;

    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;

}
