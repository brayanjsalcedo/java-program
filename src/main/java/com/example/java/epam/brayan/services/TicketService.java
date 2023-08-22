package com.example.java.epam.brayan.services;

import com.example.java.epam.brayan.data.entities.Ticket;
import com.example.java.epam.brayan.data.repositories.TicketRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;

    @Transactional
    public Optional<Ticket> loadTicket(long id) {
        return ticketRepository.findById(id);
    }
}
