package com.example.java.epam.brayan.services.data;

import lombok.Value;

@Value
public class TicketEvent {
    long id;
    String category;
    long eventId;
    long place;
    long userId;
}
