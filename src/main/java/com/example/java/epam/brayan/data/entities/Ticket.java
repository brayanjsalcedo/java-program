package com.example.java.epam.brayan.data.entities;

import com.example.java.epam.brayan.consts.Consts;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Ticket")
public class Ticket {
    @Id
    @GeneratedValue
    long ticketId;

    @Enumerated(EnumType.STRING)
    Consts.Category category;

    @ManyToOne
    User user;

    @ManyToOne
    Event event;
}
