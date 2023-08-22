package com.example.java.epam.brayan.services;

import com.example.java.epam.brayan.data.entities.Ticket;
import com.example.java.epam.brayan.data.repositories.TicketRepository;
import com.example.java.epam.brayan.services.data.UpdatedTicket;
import com.example.java.epam.brayan.services.mappers.UpdatedTicketMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class UpdateTicketService {
    private final TicketRepository ticketRepository;
    private final UpdatedTicketMapper updatedTicketMapper;

    @Transactional
    public void updateTicket(long id, UpdatedTicket updateTicket) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ticket not found"));

        Ticket updatedTicket = updatedTicketMapper.updateTicket(updateTicket, ticket);

        ticketRepository.save(updatedTicket);
    }
}
