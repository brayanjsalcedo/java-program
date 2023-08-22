package com.example.java.epam.brayan.services.mappers;

import com.example.java.epam.brayan.config.MappingConfig;
import com.example.java.epam.brayan.data.entities.Event;
import com.example.java.epam.brayan.services.data.NewEvent;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(config = MappingConfig.class)
@Component
public interface NewEventMapper {
    Event toEvent(NewEvent newEvent);
}
