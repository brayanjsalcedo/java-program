package com.example.java.epam.brayan.data.entities;

import com.example.java.epam.brayan.consts.Consts;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Ticket {
    @Id
    @SequenceGenerator(
            name = "ticket_id_sequence",
            sequenceName = "ticket_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ticket_id_sequence"
    )
    long id;

    @Enumerated(EnumType.STRING)
    Consts.Category category;

    @ManyToOne
    @JoinColumn(name = "usr_id", referencedColumnName = "id")
    User user;

    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    Event event;

    long place;
}
