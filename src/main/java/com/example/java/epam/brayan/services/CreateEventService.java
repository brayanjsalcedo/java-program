package com.example.java.epam.brayan.services;

import com.example.java.epam.brayan.data.entities.Event;
import com.example.java.epam.brayan.data.repositories.EventRepository;
import com.example.java.epam.brayan.services.data.NewEvent;
import com.example.java.epam.brayan.services.mappers.NewEventMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateEventService {
    private final EventRepository eventRepository;
    private final NewEventMapper newEventMapper;

    @Transactional
    public Event createEvent(NewEvent newEvent) {
        return eventRepository.save(newEventMapper.toEvent(newEvent));
    }
}
