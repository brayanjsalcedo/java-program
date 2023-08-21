package com.example.java.epam.brayan.controllers;

import com.example.java.epam.brayan.controllers.requests.CreateTicketRequest;
import com.example.java.epam.brayan.controllers.requests.UpdateTicketRequest;
import com.example.java.epam.brayan.data.entities.Ticket;
import com.example.java.epam.brayan.services.*;
import com.example.java.epam.brayan.services.data.NewTicket;
import com.example.java.epam.brayan.services.data.UpdateTicket;
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
    private final UpdateTicketService updateTicketService;

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

    @PutMapping("{id}")
    public void updateTicket(
            @PathVariable("id") long id,
            @RequestBody UpdateTicketRequest updateTicketRequest
    ) {
        log.debug("Update ticket by id {}: {}", id, updateTicketRequest);

        updateTicketService.updateTicket(
                id,
                UpdateTicket.builder()
                        .category(updateTicketRequest.getCategory())
                        .place(updateTicketRequest.getPlace())
                        .build()
        );
    }
}
