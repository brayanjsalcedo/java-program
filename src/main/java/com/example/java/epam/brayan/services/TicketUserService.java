package com.example.java.epam.brayan.services;

import com.example.java.epam.brayan.data.entities.Ticket;
import com.example.java.epam.brayan.data.entities.User;
import com.example.java.epam.brayan.data.repositories.TicketUserRepository;
import com.example.java.epam.brayan.data.repositories.UserRepository;
import com.example.java.epam.brayan.services.data.TicketUser;
import com.example.java.epam.brayan.services.mappers.TicketUserMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketUserService {
    private final TicketUserRepository ticketUserRepository;
    private final UserRepository userRepository;
    private final TicketUserMapper ticketUserMapper;

    public Iterable<TicketUser> getBookedTickets(long userId, int pageSize, int pageNum) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        PageRequest pageRequest = PageRequest.of(pageNum - 1, pageSize, Sort.by(Sort.Direction.DESC, "event.date"));
        Page<Ticket> ticketPage = ticketUserRepository.findByUser(user, pageRequest);

        return ticketUserMapper.toList(ticketPage.getContent());
    }
}
