package dev.marvin.ticketbooking.event;

import dev.marvin.ticketbooking.ticket.Ticket;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class Event {
    private UUID id;
    private String name;
    private LocalDateTime dateOfEvent;
    private String location;
    private Integer capacity;
    private Ticket ticket;

    //TODO: add image

}
