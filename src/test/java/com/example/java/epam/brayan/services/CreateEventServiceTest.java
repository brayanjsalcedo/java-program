package com.example.java.epam.brayan.services;

import com.example.java.epam.brayan.data.entities.Event;
import com.example.java.epam.brayan.data.repositories.EventRepository;
import com.example.java.epam.brayan.services.data.NewEvent;
import com.example.java.epam.brayan.services.mappers.NewEventMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CreateEventServiceTest {

    @Mock
    private EventRepository eventRepository;
    @Mock
    private NewEventMapper newEventMapper;
    @Mock
    private NewEvent newEvent;
    @Mock
    private Event expectedEvent;

    @Test
    void createEvent() {
        CreateEventService createEventService = new CreateEventService(eventRepository, newEventMapper);

        when(eventRepository.save(any())).thenReturn(expectedEvent);
        when(newEventMapper.toEvent(any())).thenReturn(expectedEvent);

        Event event = createEventService.createEvent(newEvent);

        assertNotNull(event);

    }
}