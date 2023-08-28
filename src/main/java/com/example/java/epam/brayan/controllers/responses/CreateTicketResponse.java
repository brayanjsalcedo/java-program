package com.example.java.epam.brayan.controllers.responses;

import com.example.java.epam.brayan.consts.Consts;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Jacksonized
@Builder
public class CreateTicketResponse {
    Consts.Category category;
    long eventId;
    long userId;
    int place;
}
