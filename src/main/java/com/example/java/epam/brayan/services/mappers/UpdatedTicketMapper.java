package com.example.java.epam.brayan.services.mappers;

import com.example.java.epam.brayan.config.MappingConfig;
import com.example.java.epam.brayan.data.entities.Ticket;
import com.example.java.epam.brayan.services.data.UpdatedTicket;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Mapper(config = MappingConfig.class)
@Component
public interface UpdatedTicketMapper {

    Ticket updateTicket(UpdatedTicket updatedTicket, @MappingTarget Ticket ticket);
}
