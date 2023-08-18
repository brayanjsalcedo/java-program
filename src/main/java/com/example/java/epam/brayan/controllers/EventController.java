package com.example.java.epam.brayan.controllers;

import com.example.java.epam.brayan.controllers.requests.CreateEventRequest;
import com.example.java.epam.brayan.data.entities.Event;
import com.example.java.epam.brayan.services.CreateEventService;
import com.example.java.epam.brayan.services.data.NewEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/events")
public class EventController {
    private final CreateEventService createEventService;

    @PostMapping
    public Event createEvent(@RequestBody CreateEventRequest createEventRequest) {
        log.debug("Creating a new event {}", createEventRequest);

        return createEventService.createEvent(
                NewEvent.builder()
                        .title(createEventRequest.getTitle())
                        .date(createEventRequest.getDate())
                        .build()
        );
    }
}
