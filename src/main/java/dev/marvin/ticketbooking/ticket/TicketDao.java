package dev.marvin.ticketbooking.ticket;

import java.util.List;
import java.util.Optional;

public interface TicketDao {
    List<Ticket> findAllTickets();
    List<Ticket> findTicketsByEventId(Long eventId);
    Optional<Ticket> findTicketById(Long id);
    Ticket save(Ticket ticket);
    void deleteTicketById(Long id);
}
