package com.example.java.epam.brayan.controllers;

import com.example.java.epam.brayan.controllers.requests.CreateTicketRequest;
import com.example.java.epam.brayan.data.entities.Ticket;
import com.example.java.epam.brayan.services.CreateTicketService;
import com.example.java.epam.brayan.services.DeleteTicketService;
import com.example.java.epam.brayan.services.TicketService;
import com.example.java.epam.brayan.services.TicketsService;
import com.example.java.epam.brayan.services.data.NewTicket;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/tickets")
public class TicketController {
    private final TicketsService ticketsService;
    private final TicketService ticketService;
    private final CreateTicketService createTicketService;
    private final DeleteTicketService deleteTicketService;

    @GetMapping
    public Iterable<Ticket> tickets() {
        log.debug("Listing tickets");
        return ticketsService.loadTickets();
    }

    @GetMapping("{id}")
    public Optional<Ticket> ticket(@PathVariable("id") long id) {
        log.debug("Get ticket by id {}", id);
        return ticketService.loadTicket(id);
    }

    @PostMapping
    public Ticket createTicket(@RequestBody CreateTicketRequest createTicketRequest) {
        log.debug("Creating a new ticket {}", createTicketRequest);

        return createTicketService.createTicket(
                NewTicket.builder()
                        .category(createTicketRequest.getCategory())
                        .place(createTicketRequest.getPlace())
                        .eventId(createTicketRequest.getEventId())
                        .userId(createTicketRequest.getUserId())
                        .build()
        );
    }

    @DeleteMapping("{id}")
    public void deleteTicket(@PathVariable("id") long id) {
        log.debug("Delete ticket by id {}", id);

        deleteTicketService.deleteTicket(id);
    }
}
