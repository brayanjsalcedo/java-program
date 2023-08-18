package com.example.java.epam.brayan.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.Instant;

@Entity
@Data
@Table(name = "Event")
public class Event {
    @Id
    @GeneratedValue
    Long eventId;

    String title;

    Instant date;
}