package dev.marvin.ticketbooking.event;

import dev.marvin.ticketbooking.ticket.Ticket;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String location;
    private Integer capacity;
    private String image;
    private String host;
    private String description;

    @OneToMany
    Set<Ticket> availableTickets = new HashSet<>();


}
