package com.example.java.epam.brayan.services;

import com.example.java.epam.brayan.data.entities.Event;
import com.example.java.epam.brayan.data.entities.Ticket;
import com.example.java.epam.brayan.data.entities.User;
import com.example.java.epam.brayan.data.repositories.TicketRepository;
import com.example.java.epam.brayan.services.data.NewTicket;
import com.example.java.epam.brayan.services.mappers.NewTicketMapper;
import com.example.java.epam.brayan.services.validators.CreateTicketValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateTicketService {
    private final CreateTicketValidator createTicketValidator;
    private final TicketRepository ticketRepository;
    private final DeductUserAccountBalanceService deductUserAccountBalanceService;
    private final NewTicketMapper newTicketMapper;

    @Transactional
    public Ticket createTicket(NewTicket newTicket) {
        Pair<User, Event> validatedUserAndEvent = createTicketValidator.validateNewTicket(newTicket);

        deductUserBalance(validatedUserAndEvent);

        return saveNewTicket(newTicket, validatedUserAndEvent);
    }

    private void deductUserBalance(Pair<User, Event> validatedUserAndEvent) {
        deductUserAccountBalanceService.deductBalance(
                validatedUserAndEvent.getFirst().getId(),
                validatedUserAndEvent.getSecond().getTicketPrice()
        );
    }

    private Ticket saveNewTicket(NewTicket newTicket, Pair<User, Event> validatedUserAndEvent) {
        Ticket ticket = newTicketMapper.toTicket(newTicket);
        ticket.setUser(validatedUserAndEvent.getFirst());
        ticket.setEvent(validatedUserAndEvent.getSecond());

        return ticketRepository.save(ticket);
    }
}
