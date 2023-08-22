package com.example.java.epam.brayan.services;

import com.example.java.epam.brayan.data.entities.Event;
import com.example.java.epam.brayan.data.entities.Ticket;
import com.example.java.epam.brayan.data.repositories.EventRepository;
import com.example.java.epam.brayan.data.repositories.TicketEventRepository;
import com.example.java.epam.brayan.services.data.TicketEvent;
import com.example.java.epam.brayan.services.mappers.NewTicketEventMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketEventService {
    private final TicketEventRepository ticketEventRepository;
    private final EventRepository eventRepository;
    private final NewTicketEventMapper newTicketEventMapper;

    public Iterable<TicketEvent> getBookedTickets(long eventId, int pageSize, int pageNum) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new EntityNotFoundException("Event not found"));

        PageRequest pageRequest = PageRequest.of(pageNum - 1, pageSize, Sort.by(Sort.Direction.ASC, "user.email"));

        Page<Ticket> ticketPage = ticketEventRepository.findByEvent(event, pageRequest);

        return newTicketEventMapper.toList(ticketPage.getContent());
    }
}
