package com.example.java.epam.brayan.data.repositories;

import com.example.java.epam.brayan.data.entities.Ticket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> {

    @Query("SELECT t FROM Ticket t JOIN FETCH t.user JOIN FETCH t.event")
    Iterable<Ticket> loadTicketsEagerly();

}
