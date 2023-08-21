package com.example.java.epam.brayan.services.data;

import com.example.java.epam.brayan.consts.Consts;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UpdateTicket {
    Consts.Category category;
    int place;
}
