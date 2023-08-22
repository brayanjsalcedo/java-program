package com.example.java.epam.brayan.data.repositories;

import com.example.java.epam.brayan.data.entities.Event;
import com.example.java.epam.brayan.data.entities.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface TicketEventRepository extends CrudRepository<Ticket, Long>  {

    Page<Ticket> findByEvent(Event event, Pageable pageable);
}
