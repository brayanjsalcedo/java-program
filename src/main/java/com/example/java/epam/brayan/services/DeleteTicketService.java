package com.example.java.epam.brayan.services;

import com.example.java.epam.brayan.data.repositories.TicketRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class DeleteTicketService {
    private final TicketRepository ticketRepository;

    @Transactional
    public void deleteTicket(long id) {
        ticketRepository.deleteById(id);
    }
}
