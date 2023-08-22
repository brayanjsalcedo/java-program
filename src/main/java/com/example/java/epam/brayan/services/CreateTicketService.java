package com.example.java.epam.brayan.services;

import com.example.java.epam.brayan.data.entities.Event;
import com.example.java.epam.brayan.data.entities.Ticket;
import com.example.java.epam.brayan.data.entities.User;
import com.example.java.epam.brayan.data.repositories.EventRepository;
import com.example.java.epam.brayan.data.repositories.TicketRepository;
import com.example.java.epam.brayan.data.repositories.UserRepository;
import com.example.java.epam.brayan.services.data.NewTicket;
import com.example.java.epam.brayan.services.mappers.NewTicketMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateTicketService {
    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    private final TicketRepository ticketRepository;
    private final NewTicketMapper newTicketMapper;

    @Transactional
    public Ticket createTicket(NewTicket newTicket) {
        Ticket ticket = newTicketMapper.toTicket(newTicket);
        User user = userRepository.findById(newTicket.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        Event event = eventRepository.findById(newTicket.getEventId())
                .orElseThrow(() -> new EntityNotFoundException("Event not found"));

        ticket.setUser(user);
        ticket.setEvent(event);

        return ticketRepository.save(ticket);
    }
}
