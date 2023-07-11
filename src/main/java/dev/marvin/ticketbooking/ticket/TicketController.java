package dev.marvin.ticketbooking.ticket;

import dev.marvin.ticketbooking.exception.ResourceNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Ticket API v1")
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {
    private final TicketService ticketService;

    @Operation(summary = "Get All Tickets")
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @Operation(summary = "Get Ticket By ID")
    @GetMapping("/{ticketId}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable("ticketId") Long ticketId) {
        Ticket ticket = ticketService.getTicketById(ticketId);
        if (ticket == null) {
            throw new ResourceNotFoundException("ticket with id [%s] not found".formatted(ticketId));
        }
        return ResponseEntity.ok(ticket);
    }

    @Operation(summary = "Get All Tickets By Event ID")
    @GetMapping("/events/{eventId}")
    public List<Ticket> getAllTicketsByEventId(@PathVariable("eventId") Long eventId){
        return ticketService.getAllTicketsByEventId(eventId);
    }

    @Operation(summary = "Create Ticket By Event ID")
    @PostMapping("/events/{eventId}")
    public ResponseEntity<Ticket> createTicket(@PathVariable("eventId") Long eventId, @RequestBody TicketDto newTicketRegistrationRequest) {
        Ticket createdTicket = ticketService.createTicket(eventId, newTicketRegistrationRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTicket);
    }

    @Operation(summary = "Delete Ticket By ID")
    @DeleteMapping("/{ticketId}")
    public ResponseEntity<Ticket> deleteTicket(@PathVariable("ticketId") Long ticketId){
        ticketService.deleteTicketById(ticketId);
        return ResponseEntity.noContent().build();
    }

}
