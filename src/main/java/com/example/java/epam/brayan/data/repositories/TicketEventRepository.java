package com.example.java.epam.brayan.data.repositories;

import com.example.java.epam.brayan.consts.Consts;
import com.example.java.epam.brayan.data.dto.TicketEvent;
import com.example.java.epam.brayan.data.entities.Ticket;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TicketEventRepository extends CrudRepository<Ticket, Long>  {

    List<TicketEvent> findByTicketIdAndCategory(long ticketId, Consts.Category category);
}
