package com.example.java.epam.brayan.services.mappers;

import com.example.java.epam.brayan.config.MappingConfig;
import com.example.java.epam.brayan.data.entities.Ticket;
import com.example.java.epam.brayan.services.data.UpdateTicket;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Mapper(config = MappingConfig.class)
@Component
public interface UpdateTicketMapper {

    Ticket updateTicket(UpdateTicket updateTicket, @MappingTarget Ticket ticket);
}
