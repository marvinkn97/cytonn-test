package dev.marvin.ticketbooking.ticket;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Primary
@Repository
public class TicketDaoJpaImpl implements TicketDao {
    private final TicketRepository ticketRepository;

    @Override
    public List<Ticket> findAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public List<Ticket> findTicketsByEventId(Long eventId) {
        return ticketRepository.findTicketByEventId(eventId);
    }

    @Override
    public Optional<Ticket> findTicketById(Long ticketId) {
        return ticketRepository.findTicketById(ticketId);
    }

    @Override
    public Ticket save(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public void deleteTicketById(Long ticketId) {
        ticketRepository.deleteById(ticketId);
    }
}
