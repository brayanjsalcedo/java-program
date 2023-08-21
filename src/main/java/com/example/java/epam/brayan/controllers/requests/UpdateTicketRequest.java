package com.example.java.epam.brayan.controllers.requests;

import com.example.java.epam.brayan.consts.Consts;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Jacksonized
@Builder
public class UpdateTicketRequest {
    Consts.Category category;
    int place;
}
