package com.example.java.epam.brayan.data.entities;

import com.example.java.epam.brayan.consts.Consts;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tickets")
public class Ticket {
    @Id
    long ticketId;

    Consts.Category category;

    @ManyToOne
    User user;
}
