package com.example.java.epam.brayan.data.entities;

import com.example.java.epam.brayan.consts.Consts;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue
    long ticketId;

    Consts.Category category;

    String name;

    @ManyToOne
    User user;
}
