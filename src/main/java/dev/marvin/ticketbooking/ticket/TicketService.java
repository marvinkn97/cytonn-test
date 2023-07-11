package dev.marvin.ticketbooking.ticket;

import dev.marvin.ticketbooking.booking.Booking;
import dev.marvin.ticketbooking.event.Event;
import dev.marvin.ticketbooking.event.EventService;
import dev.marvin.ticketbooking.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TicketService {
    private final TicketDao ticketDao;
    private final EventService eventService;

    public List<Ticket> getAllTickets() {
        return ticketDao.findAllTickets();
    }

    public Ticket getTicketById(Long ticketId) {
        return ticketDao.findTicketById(ticketId).orElseThrow(() -> new ResourceNotFoundException("ticket with id [%s] not found".formatted(ticketId)));
    }

    public List<Ticket> getAllTicketsByEventId(Long eventId) {
        List<Ticket> tickets = ticketDao.findTicketsByEventId(eventId);
        if (tickets.isEmpty()) {
            throw new ResourceNotFoundException("no tickets");
        }
        return tickets;
    }

    public Ticket createTicket(Long eventId, TicketDto newTicketRegistrationRequest) {
        Event event = eventService.getEventById(eventId);

        Ticket ticket = Ticket.builder()
                .ticketType(TicketType.valueOf(newTicketRegistrationRequest.ticketType().toUpperCase()))
                .price(newTicketRegistrationRequest.price())
                .event(event)
                .quantity(newTicketRegistrationRequest.quantity())
                .available(true)
                .build();

        return ticketDao.save(ticket);
    }

    public void deleteTicketById(Long ticketId) {
        ticketDao.deleteTicketById(ticketId);
    }

    public void bookTicket(Long ticketId) {
        Ticket ticket = ticketDao.findTicketById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("ticket with id [%s] not found".formatted(ticketId)));

        Event event = ticket.getEvent();
        int currentTicketQuantity = ticket.getQuantity();

        if (currentTicketQuantity < 0) {
            throw new IllegalStateException("no tickets available");
        }


        ticket.setQuantity(currentTicketQuantity - 1);
        ticketDao.save(ticket);


        Booking booking = Booking.builder().build();


    }


}
