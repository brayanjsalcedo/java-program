package com.example.java.epam.brayan.services.validators;

import com.example.java.epam.brayan.data.entities.Event;
import com.example.java.epam.brayan.data.entities.User;
import com.example.java.epam.brayan.data.entities.UserAccount;
import com.example.java.epam.brayan.data.repositories.EventRepository;
import com.example.java.epam.brayan.data.repositories.UserAccountRepository;
import com.example.java.epam.brayan.data.repositories.UserRepository;
import com.example.java.epam.brayan.services.data.NewTicket;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateTicketValidator {
    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    private final UserAccountRepository userAccountRepository;

    @Transactional
    public Pair<User, Event> validateNewTicket(NewTicket newTicket) {
        User user = userRepository.findById(newTicket.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        Event event = eventRepository.findById(newTicket.getEventId())
                .orElseThrow(() -> new EntityNotFoundException("Event not found"));
        UserAccount userAccount = userAccountRepository.findByUserId(newTicket.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User account not found"));

        if (userAccount.getBalance() < event.getTicketPrice()) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        return Pair.of(user, event);
    }
}
