package com.example.java.epam.brayan.services.data;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class TicketEvent {
    long id;
    String category;
    long eventId;
    long place;
    long userId;
}
