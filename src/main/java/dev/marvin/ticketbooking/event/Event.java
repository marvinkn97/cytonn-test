package dev.marvin.ticketbooking.event;

import dev.marvin.ticketbooking.ticket.Ticket;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private LocalDateTime endDate;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private Integer capacity;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String host;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "event")
    private List<Ticket> tickets = new ArrayList<>();

}
