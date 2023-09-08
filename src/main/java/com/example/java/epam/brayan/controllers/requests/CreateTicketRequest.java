package com.example.java.epam.brayan.controllers.requests;

import com.example.java.epam.brayan.consts.Consts;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Jacksonized
@Builder
public class CreateTicketRequest {
    Consts.Category category;
    long eventId;
    @NotNull
    long userId;
    int place;
}
