package com.example.java.epam.brayan.controllers.requests;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.time.Instant;

@Value
@Jacksonized
@Builder
public class CreateEventRequest {
    String title;
    Instant date;
}
