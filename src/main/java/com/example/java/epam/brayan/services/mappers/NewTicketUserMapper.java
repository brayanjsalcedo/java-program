package com.example.java.epam.brayan.services.mappers;

import com.example.java.epam.brayan.config.MappingConfig;
import com.example.java.epam.brayan.data.entities.Ticket;
import com.example.java.epam.brayan.services.data.TicketUser;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(config = MappingConfig.class)
@Component
public interface NewTicketUserMapper {
    List<TicketUser> toList(List<Ticket> tickets);
    TicketUser toTicketUser(Ticket ticket);
}
