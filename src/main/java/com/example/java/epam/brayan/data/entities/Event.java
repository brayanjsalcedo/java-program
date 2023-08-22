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
    @SequenceGenerator(
            name = "event_id_sequence",
            sequenceName = "event_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "event_id_sequence"
    )
    long id;

    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private Set<Ticket> tickets = new HashSet<>();


    String title;
    Instant date;
}