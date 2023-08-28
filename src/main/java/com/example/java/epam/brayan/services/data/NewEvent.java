package com.example.java.epam.brayan.services.data;

import lombok.Builder;
import lombok.Value;

import java.time.Instant;
@Value
@Builder
public class NewEvent {
    String title;
    Instant date;
    double ticketPrice;
}
