package com.example.java.epam.brayan.services.mappers;

import com.example.java.epam.brayan.config.MappingConfig;
import com.example.java.epam.brayan.data.entities.Ticket;
import com.example.java.epam.brayan.services.data.NewTicket;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(config = MappingConfig.class)
@Component
public interface NewTicketMapper {
    Ticket toTicket(NewTicket newTicket);
}
