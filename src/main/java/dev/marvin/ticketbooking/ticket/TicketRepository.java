package dev.marvin.ticketbooking.ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Optional<Ticket> findTicketById(Long ticketId);
    List<Ticket> findTicketByEventId(Long eventId);
}
