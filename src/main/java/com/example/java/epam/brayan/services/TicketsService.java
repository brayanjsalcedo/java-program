package com.example.java.epam.brayan.services;

import com.example.java.epam.brayan.data.entities.Ticket;
import com.example.java.epam.brayan.data.repositories.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketsService {
    private final TicketRepository ticketRepository;

    public Iterable<Ticket> loadTickets() {
        return ticketRepository.loadTicketsEagerly();
    }
}
