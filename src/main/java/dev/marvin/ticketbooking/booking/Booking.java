package dev.marvin.ticketbooking.booking;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
public class Booking {
    @Id
    @SequenceGenerator(name = "booking_id_sequence", sequenceName = "booking_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_id_sequence")
    @Column(updatable = false)
    private UUID id;

    @CreationTimestamp
    private LocalDateTime createdDate;

    private UUID ticketId;
    private UUID eventId;
    private UUID userId;
}
