package com.example.java.epam.brayan.data.entities;

import com.example.java.epam.brayan.consts.Consts;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    long id;

    @Enumerated(EnumType.STRING)
    Consts.Category category;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(name = "event_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Event event;

    long place;
}
