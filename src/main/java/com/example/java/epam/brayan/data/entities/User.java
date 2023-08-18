package com.example.java.epam.brayan.data.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "usr")
public class User {
    @Id
    @SequenceGenerator(
            name = "usr_id_sequence",
            sequenceName = "usr_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "usr_id_sequence"
    )
    long id;

    String name;
    String email;
}
