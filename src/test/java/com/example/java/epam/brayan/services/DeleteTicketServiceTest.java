package com.example.java.epam.brayan.services;

import com.example.java.epam.brayan.data.repositories.TicketRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DeleteTicketServiceTest {

    @Mock
    private TicketRepository ticketRepository;

    @InjectMocks
    private DeleteTicketService deleteTicketService;

    @Test
    void deleteTicket() {
        long ticketId = 1L;

        deleteTicketService.deleteTicket(ticketId);

        verify(ticketRepository, times(1)).deleteById(ticketId);
    }
}