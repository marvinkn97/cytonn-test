package dev.marvin.ticketbooking.ticket;

import java.util.List;

public interface TicketDao {
    List<Ticket> findAllTickets();
    Ticket findTicketById(Long id);
    Ticket save(Ticket ticket);
    void deleteTicketById(Long id);
}
