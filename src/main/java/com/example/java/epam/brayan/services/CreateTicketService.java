package com.example.java.epam.brayan.services;

import com.example.java.epam.brayan.data.entities.Ticket;
import com.example.java.epam.brayan.data.repositories.TicketRepository;
import com.example.java.epam.brayan.services.data.NewTicket;
import com.example.java.epam.brayan.services.mappers.NewTicketMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateTicketService {
    private final TicketRepository ticketRepository;
    private final NewTicketMapper newTicketMapper;

    @Transactional
    public Ticket createTicket(NewTicket newTicket) {
        return ticketRepository.save(newTicketMapper.toTicket(newTicket));
    }
}
