package com.example.java.epam.brayan.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name =  "\"User\"")
public class User {
    @Id
    @GeneratedValue
    long userId;

    String name;

    String email;
}
