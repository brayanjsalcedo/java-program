package com.example.java.epam.brayan.services.data;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class TicketUser {
    long id;
    String category;
    long userId;
    long place;
}
