package dev.marvin.ticketbooking.event;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {
    Optional<Event> findEventById(UUID id);
    Optional<Event> findEventByName(String name);

}
