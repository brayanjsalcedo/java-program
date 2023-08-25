package com.example.java.epam.brayan.data.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    long id;

    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private Set<Ticket> tickets = new HashSet<>();


    String title;
    Instant date;
    double ticketPrice;
}