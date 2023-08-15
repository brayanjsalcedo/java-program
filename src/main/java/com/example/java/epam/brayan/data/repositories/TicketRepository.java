package com.example.java.epam.brayan.data.repositories;

import com.example.java.epam.brayan.data.entities.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
}
