package com.example.java.epam.brayan.controllers;

import com.example.java.epam.brayan.controllers.requests.CreateTicketRequest;
import com.example.java.epam.brayan.controllers.requests.UpdateTicketRequest;
import com.example.java.epam.brayan.controllers.responses.CreateTicketResponse;
import com.example.java.epam.brayan.data.entities.Ticket;
import com.example.java.epam.brayan.jms.producers.TicketBookingPublisher;
import com.example.java.epam.brayan.services.*;
import com.example.java.epam.brayan.services.data.NewTicket;
import com.example.java.epam.brayan.services.data.UpdatedTicket;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    private final TicketBookingPublisher jmsService;

    @GetMapping
    public ModelAndView tickets() {
        log.debug("Listing tickets");
        Iterable<Ticket> tickets = ticketsService.loadTickets();

        ModelAndView mav = new ModelAndView("tickets");

        mav.addObject("tickets", tickets);
        return mav;
    }

    @GetMapping("{id}")
    public Optional<Ticket> ticket(@PathVariable("id") long id) {
        log.debug("Get ticket by id {}", id);
        return ticketService.loadTicket(id);
    }

    @PostMapping
    public CreateTicketResponse createTicket(@Valid @RequestBody CreateTicketRequest createTicketRequest) {
        log.debug("Creating a new ticket {}", createTicketRequest);

        Ticket ticket = createTicketService.createTicket(
                NewTicket.builder()
                        .category(createTicketRequest.getCategory())
                        .place(createTicketRequest.getPlace())
                        .eventId(createTicketRequest.getEventId())
                        .userId(createTicketRequest.getUserId())
                        .build()
        );

        return CreateTicketResponse.builder()
                .category(ticket.getCategory())
                .eventId(ticket.getEvent().getId())
                .userId(ticket.getUser().getId())
                .build();
    }

    @PostMapping("/async")
    public String createTicketAsync(@RequestBody CreateTicketRequest createTicketRequest) {
        jmsService.sendTicketRequest(createTicketRequest);

        return "Your request is being processed asynchronously. Please wait.";
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
                UpdatedTicket.builder()
                        .category(updateTicketRequest.getCategory())
                        .place(updateTicketRequest.getPlace())
                        .build()
        );
    }
}
