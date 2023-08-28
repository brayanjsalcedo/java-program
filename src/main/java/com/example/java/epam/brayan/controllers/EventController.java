package com.example.java.epam.brayan.controllers;

import com.example.java.epam.brayan.controllers.requests.CreateEventRequest;
import com.example.java.epam.brayan.data.entities.Event;
import com.example.java.epam.brayan.services.CreateEventService;
import com.example.java.epam.brayan.services.TicketEventService;
import com.example.java.epam.brayan.services.data.NewEvent;
import com.example.java.epam.brayan.services.data.TicketEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/events")
public class EventController {
    private final CreateEventService createEventService;
    private final TicketEventService ticketEventService;

    @PostMapping
    public Event createEvent(@RequestBody CreateEventRequest createEventRequest) {
        log.debug("Creating a new event {}", createEventRequest);

        return createEventService.createEvent(
                NewEvent.builder()
                        .title(createEventRequest.getTitle())
                        .date(createEventRequest.getDate())
                        .ticketPrice(createEventRequest.getTicketPrice())
                        .build()
        );
    }

    @GetMapping("/{id}/tickets")
    public Iterable<TicketEvent> getBookedTicketsForEvent(
            @PathVariable Long id,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "1") int pageNum
    ) {
        log.debug("Get booked tickets by event {}", id);

        return ticketEventService.getBookedTickets(id, pageSize, pageNum);
    }
}
