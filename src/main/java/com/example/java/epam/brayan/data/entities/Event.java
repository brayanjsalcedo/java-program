package com.example.java.epam.brayan.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.Instant;

@Entity
@Data
public class Event {
    @Id
    Long eventId;

    String title;

    Instant date;
}